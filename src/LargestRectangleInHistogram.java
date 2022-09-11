import java.util.Stack;

/**
 * Problem:
 * Given an array of integers heights representing the histogram's bar height
 * where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 * Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Times: 1
 * Rating: 0
 */


class LargestRectangleInHistogram {

    //https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution/213800
    public int largestRectangleAreaStack(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len;) {
            int h = (i == len ? 0 : heights[i]); //So that last element is popped in the end
            //If current height is more than stack-top, push
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                //If current height is less than stack-top, pop.
                int curHeight = heights[stack.pop()];
                int rightBoundary = i;
                int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
                int width = rightBoundary - leftBoundary;
                maxArea = Math.max(maxArea, (curHeight * width));
            }
        }
        return maxArea;
    }

    //https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
    public int largestRectangleAreaItr(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        //What's the largest area from any bar? Current + far as possible to the left + right
        int[] smallestOnTheLeft = new int[heights.length];
        int[] smallestOnTheRight = new int[heights.length];

        smallestOnTheLeft[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int pointer = i - 1;
            while (pointer >= 0 && heights[pointer] >= heights[i]) {
                pointer = smallestOnTheLeft[pointer];
            }
            smallestOnTheLeft[i] = pointer;
        }

        smallestOnTheRight[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int pointer = i + 1;
            while (pointer < heights.length && heights[pointer] >= heights[i]) {
                pointer = smallestOnTheRight[pointer];
            }
            smallestOnTheRight[i] = pointer;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (smallestOnTheRight[i] - smallestOnTheLeft[i] - 1));
        }
        return maxArea;
    }
}
