/**
 * @author Davis Jeffrey
 */
package patterns.two_pointer;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. 
 * '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Link: https://leetcode.com/problems/backspace-string-compare/
 * 
 * Solution: Start from the end, skip chars when '#' appears 
 */

class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int p1 = s.length() - 1;
        int p2 = t.length() - 1;
        
        while (p1 > 0 && p2 > 0) {
            if (s.charAt(p1) == '#') {
                p1 = p1 - 2;
            }
            if (t.charAt(p2) == '#') {
                p2 = p2 - 2;
            }
            if (p1 >= 0 && p2 >= 0) {
                if (s.charAt(p1) != (t.charAt(p2))) {
                    return false;
                }
                p1--;
                p2--;
            }
        }
        return p1 <= 0 && p2 <= 0;
    }
}
