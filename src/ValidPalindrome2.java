/**
 * Problem:
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 * Link: https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Times: 1
 * Rating: 4
 */


class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, 1);
    }

    private boolean validPalindrome(String s, int strikes) {
        //System.out.println(s);
        if (s.length() <= 1) {
            return true;
        }
        int p1 = 0;
        int p2 = s.length() - 1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(p1) != s.charAt(p2)) {
                if (strikes == 1) {
                    return validPalindrome(s.substring(p1 + 1, p2 + 1), 0)
                        || validPalindrome(s.substring(p1, p2), 0); //Bug 1: p2 needs to be decremented
                } else {
                    return false;
                }
            }
            //Bug 2: Forgot to increment :|
            p1++;
            p2--;
        }
        return true;
    }
}
