/**
 * Problem:
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1],
 * then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * Link: https://leetcode.com/problems/reverse-integer/
 *
 * Times: 1
 * Rating: 5
 */


class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        //Checking for sign changes as an indicator of overflow won't work here!
        //This is because given a sufficiently large number like 964632435, doing
        //964632435 * 10 can cycle through + and - multiple times.
        while (x != 0) {
            //Even this won't work for certain magic numbers. Divide MAX_VALUE and compare.
            if ((res * 10) / 10 != res) {
                //Because if it crosses the max_value threshold and cycles, original value will be lost
                return 0;
            }
            res = (res * 10) + (x % 10);
            x = x / 10;
        }
        return res;
    }
}
