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

    public int trap(int[] heights) {
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
