/**
 * Problem:
 * Given a list of distinct integers pushes, and another list of integers pops, return whether this is a valid sequence of stack push and pop actions.
 * <p>
 * Link: https://binarysearch.com/problems/Stack-Sequence
 */

import java.util.Stack;

class StackSequence {
    private boolean solveIteratively(int[] pushes, int[] pops) {
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        //Greedily pop whatever is possible
        for (int i = 0; i < pushes.length; i++) {
            stack.push(pushes[i]);
            while (!stack.isEmpty() && p < pops.length && stack.peek() == pops[p]) {
                stack.pop();
                p++;
            }
        }
        //When all pops have completed, it can be said to be a valid sequence.
        return p == pops.length;
    }

    public boolean solve(int[] pushes, int[] pops) {
        boolean result = false;
        //Iterative
        result = solveIteratively(pushes, pops);
        //Recursive
        result = solve(pushes, 0, pops, 0, new Stack<Integer>());

        return result;
    }

    private boolean solve(int[] pushes, int pushIndex, int[] pops, int popIndex, Stack<Integer> stack) {
        //When all pops have completed, it can be said to be a valid sequence.
        if (popIndex >= pops.length) {
            return true;
        }
        //No more elements to pop, but pops are present
        if (stack.isEmpty() && pushIndex >= pushes.length && popIndex < pops.length) {
            return false;
        }

        //Pop greedily, recursively
        if (!stack.isEmpty() && pops[popIndex] == stack.peek()) {
            stack.pop();
            return solve(pushes, pushIndex, pops, popIndex + 1, stack);
        }

        //If nothing more to pop, push one and rinse and repeat.
        if (pushIndex < pushes.length) {
            stack.push(pushes[pushIndex]);
            return solve(pushes, pushIndex + 1, pops, popIndex, stack);
        }

        return false;
    }
}
