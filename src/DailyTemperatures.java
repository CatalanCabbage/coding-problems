import java.util.Stack;

/**
 * Problem:
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Link: https://leetcode.com/problems/daily-temperatures/
 */


class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        //Invariant: Make the stack decreasing
        //When bigger entry is found, this should be the next greater entry for some elements before it in the stack,
        //So pop previous

        int i = 0;
        while (i < temperatures.length) {
            int temp = temperatures[i];
            if (stack.isEmpty() || temp <= temperatures[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                //Current element is greater than prev, so this is the next greater temp
                int prevTempIndex = stack.pop();
                result[prevTempIndex] = i - prevTempIndex;
            }
        }
        //Note: At this point, there might still be elements in the stack.
        //But since expected output is 0 in those places and array val is 0 by default, we can ignore them.
        return result;
    }
}
