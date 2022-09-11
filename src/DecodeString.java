import java.util.ArrayDeque;

/**
 * Problem: Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
 * is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid;
 * there are no extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that
 * digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 * Link: https://leetcode.com/problems/decode-string/
 */


class DecodeString {
    public String decodeString(String s) {
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        ArrayDeque<String> resStack = new ArrayDeque<>();
        int num = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                //If it's a digit, continue building num
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                //If a bracket is starting, push the existing number and string onto the stacks
                numStack.push(num);
                num = 0;
                resStack.push(res);
                res = "";
            } else if (ch == ']') {
                //If a bracket is ending, pop number, do computation and merge with the previous string
                //We merge with the previous string because it also might be a part of a deeper computation
                StringBuilder sb = new StringBuilder(resStack.pop());
                int timesToRepeat = numStack.pop();
                for (int j = 0; j < timesToRepeat; j++) {
                    sb = sb.append(res);
                }
                res = sb.toString();
            } else {
                //If it's a character, keep adding it to our string
                res += ch;
            }
        }
        return res;
    }
}
