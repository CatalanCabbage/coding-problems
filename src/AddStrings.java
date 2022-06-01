/**
 * Problem:
 * Given two non-negative integers, num1 and num2 represented as string,
 * return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
 * You must also not convert the inputs to integers directly.
 *
 * Link: https://leetcode.com/problems/add-strings/
 *
 * Eg: Input: num1 = "11", num2 = "123"
 * Output: "134"
 */


class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1.isEmpty() && num2.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        boolean moreDigitsExist = true;
        int i = 0;
        int carry = 0;
        while (moreDigitsExist) {
            int digit1 = 0;
            int digit2 = 0;
            //To get int from char, you can convert it using parseInt or minus '0' (which subtracts by ascii value)
            if (i < num1.length()) {
                //Chars can't be parsed to ints
                //Remember to do num1.length() - 1
                digit1 = num1.charAt(num1.length() - i - 1) - '0';
            }
            if (i < num2.length()) {
                digit2 = Integer.parseInt(num2.charAt(num2.length() - i - 1) + "");
            }

            int resultDigit = digit1 + digit2 + carry;
            sb.append(resultDigit % 10);
            carry = resultDigit / 10;
            i++; //Remember to increment before adding checks
            moreDigitsExist = carry != 0 || i < num1.length() || i < num2.length();
        }
        return sb.reverse().toString();
    }
}
