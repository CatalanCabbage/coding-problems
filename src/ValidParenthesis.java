import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Problem:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Link: https://leetcode.com/problems/valid-parentheses/
 * Times: 2
 * Rating: 3
 */


class ValidParenthesis {
    public boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(')');
            } else if (chars[i] == '[') {
                stack.push(']');
            } else if (chars[i] == '{' ) {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != chars[i]) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    @Test
    @DisplayName("Check if parenthesis are valid")
    void isValid() {
        assertTrue(isValidParenthesis("{}"));
    }
}
