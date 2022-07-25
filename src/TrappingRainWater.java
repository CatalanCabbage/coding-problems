/**
 * @author Davis Jeffrey
 */

/**
 * Problem: https://leetcode.com/problems/trapping-rain-water/
 * Statement: Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = {4, 2, 0, 3, 2, 5};
        int trapped = new TrappingRainWater().trap(heights);
        System.out.println(trapped);
    }

    //Todo:
    //https://leetcode.com/problems/trapping-rain-water/discuss/17414/A-stack-based-solution-for-reference-inspired-by-Histogram/400375

    //https://leetcode.com/problems/trapping-rain-water/discuss/17395/A-different-O(n)-approach-easy-to-understand-and-simple-code
    public int trap(int[] height) {
        int length = height.length;
        //Intuition:
        //1. Each column contributes to the water count
        //as long as there's a taller wall on the left and the right.
        //2. How much does it contribute? (min height of enclosing walls - current height)

        //Populate tallest walls to the left
        int[] tallestWallLeft = new int[length];
        tallestWallLeft[0] = height[0];
        for (int i = 1; i < length; i++) {
            tallestWallLeft[i] = Math.max(tallestWallLeft[i - 1], height[i]);
        }

        //Populate tallest walls to the right
        int[] tallestWallRight = new int[length];
        tallestWallRight[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            tallestWallRight[i] = Math.max(tallestWallRight[i + 1], height[i]);
        }

        //Calculate contribution by each column
        int totalWater = 0;
        for (int i = 0; i < length; i++) {
            if (Math.min(tallestWallLeft[i], tallestWallRight[i]) > height[i]) {
                totalWater += Math.min(tallestWallLeft[i], tallestWallRight[i]) - height[i];
            }
        }
        return totalWater;
    }

    public int trapBruteForce(int[] heights) {
        int leftEdge = 0;
        int trappedWater = 0;
        while (leftEdge < heights.length) {
            int rightEdge = calculateRightEdge(heights, leftEdge);
            //Calculation is necessary only if there's a space of at least 1 index between left and right edges
            if (!(rightEdge > leftEdge + 1)) {
                leftEdge++;
                continue;
            } else {
                trappedWater = trappedWater + calculateTrappedWater(heights, leftEdge, rightEdge);
                leftEdge = rightEdge;
            }
        }
        return trappedWater;
    }

    //Given a left edge(wall), return the appropriate right edge(wall) that forms a mini "container".
    private int calculateRightEdge(int[] heights, int leftEdge) {
        int maxHeightIndex = leftEdge + 1;
        for (int i = leftEdge + 1; i < heights.length; i++) {
            //Edge is > left edge, so it forms the right edge of the container
            if (heights[i] >= heights[leftEdge]) {
                return i;
            } else {
                maxHeightIndex = heights[i] > heights[maxHeightIndex] ? i : maxHeightIndex;
            }
        }
        //All remaining heights were < left edge, so return the highest height on the right, which will form the right edge
        //(if there are 2 indices with the same highest height, return the leftmost index)
        return maxHeightIndex;
    }

    //Given left and right edge, return the max amount of water that'll be trapped between them
    private int calculateTrappedWater(int[] heights, int leftEdge, int rightEdge) {
        if (leftEdge >= rightEdge) return 0;
        int trappedWater = 0;
        //waterLevel is the minimum of left and right edges
        int waterLevel = heights[leftEdge] > heights[rightEdge] ? heights[rightEdge] : heights[leftEdge];
        for (int i = leftEdge + 1; i < rightEdge; i++) {
            trappedWater = trappedWater + (waterLevel - heights[i]);
        }
        return trappedWater;
    }

}
