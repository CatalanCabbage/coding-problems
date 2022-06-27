/**
 * Problem:
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 * Link: https://leetcode.com/problems/add-digits/
 *
 * Times: 1
 * Rating: 5
 */


class AddDigits {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }
}
