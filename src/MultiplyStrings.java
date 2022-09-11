import java.util.Arrays;

/**
 * Problem:
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Link: https://leetcode.com/problems/multiply-strings/
 */


class MultiplyStrings {
    public String multiply(String s1, String s2) {
        //Always check for - '0'!

        //For each number in s1, multiply each number in s2, RTL while maintaining carry
        //Add everything
        int[] res = new int[s1.length() + s2.length()];
        for (int i = s1.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int zeroes = s1.length() - 1; zeroes > i; zeroes--) {
                sb.append('0');
            }
            int s1Number = s1.charAt(i) - '0';
            int carry = 0;

            //Multiply each number in s2 by s1's char
            for (int j = s2.length() - 1; j >= 0; j--) {
                int s2Number = s2.charAt(j) - '0';

                int multipliedVal = s1Number * s2Number;
                int currentVal = multipliedVal + carry;
                if (currentVal > 9) {
                    carry = currentVal / 10;
                    currentVal = currentVal % 10;
                } else {
                    carry = 0;
                }
                sb.insert(0, currentVal);
            }
            if (carry != 0) {
                sb.insert(0, carry);
            }

            //System.out.println(sb.toString());
            int sumCarry = 0;
            String sum = sb.reverse().toString();
            //System.out.println(sum);
            for (int j = 0; j < res.length; j++) {
                int currentNum = j < sum.length() ? sum.charAt(j) - '0' : 0;
                int existingNum = res[j];
                //System.out.println("currentNum:  " + currentNum + ", existingNum: " + existingNum + ", sumCarry: " + sumCarry);
                int totalNum = currentNum + existingNum + sumCarry;
                if (totalNum > 9) {
                    sumCarry = totalNum / 10;
                    totalNum = totalNum % 10;
                } else {
                    sumCarry = 0;
                }
                //System.out.println("TotalNum is " + totalNum);
                res[j] = totalNum % 10;
                //System.out.println("Number at " + j + " is " + res[j]);
            }

        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            result.append(res[i]);
        }
        String daRealResult = result.reverse().toString().replaceAll("^0+", "");
        return daRealResult.isEmpty() ? "0" : daRealResult;
    }
}
