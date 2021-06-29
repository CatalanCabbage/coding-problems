/**
 * Problem:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Eg: Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Link: https://leetcode.com/problems/generate-parentheses/
 */


class GenerateParentheses {
    private List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generateParenthesis("", n, n);
        return list;
    }

    private void generateParenthesis(String currentStr, int left, int right) {
        if (left == 0 && right == 0) {
            System.out.print("Adding to list: " + currentStr);
            list.add(currentStr);
            return;
        }

        //There are 2 ways we can proceed.
        //1. Add a left parenthesis
        //2. Add a right parenthesis
        //Invariant: Number of right parentheses in a string <= left, or it's invalid.
        //ie., the number of right parentheses remaining > remaining left parentheses

        //Add a left parenthesis and try all combinations
        if (left > 0) {
            generateParenthesis(currentStr + "(", left - 1, right);
        }
        if (right > left) {
            generateParenthesis(currentStr + ")", left, right - 1);
        }
    }
}
