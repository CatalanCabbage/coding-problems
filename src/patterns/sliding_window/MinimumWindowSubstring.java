/**
 * @author Davis Jeffrey
 */
package patterns.sliding_window;

/**
 * Given two strings s and t, return the minimum window substring of s
 * such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 *
 * Eg: Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC" //The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * Link: https://leetcode.com/problems/minimum-window-substring/
 */

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int[] map = new int[128];
        //Add all required chars to the map
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0;
        int right = 0;
        int counter = t.length();
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < s.length()) {
            int c = s.charAt(right);

            //Note that since we do this, counter will change only when the current char is needed.
            //Case1: window is 'aa', target is 'aa', current is 'c': Check will fail.
            //Case2: window is 'aa', target is 'aa', current is 'a': map[c] will be 0, this check will fail.
            if (map[c] > 0) {
                counter--;
            }
            map[c]--;
            //We perform all operations and then increment right before isValid;
            //so in the end, it works since substring is right exclusive
            right++;

            //As long as window has all chars we need, shrink it
            while(counter == 0) {
                //Check if valid
                if (minLength > right - left) {
                    minLength = right - left;
                    startIndex = left;
                }
                c = s.charAt(left);
                map[c]++;
                if (map[c] > 0) {
                    counter++;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }

    //Epic...fail
    /*
    public static String minWindow(String s, String subset) {
        //Needed chars
        //Start from left
        //Note the start and end for each case
        //chars contains all the chars that are needed, with the correct frequency
        String solution = "";
        int[] chars = new int[100];
        int[] winChars = new int[100];
        for (char c : subset.toCharArray()) {
            chars[c - 'A'] = chars[c - 'A'] + 1;
        }

        //Start checking s
        int right = -1;
        int left = 0;
        while (right < s.length() - 1) {
            right++;
            char rightChar = s.charAt(right);
            //Bug2: Need to validate only chars that are a part of subset
            if (chars[rightChar - 'A'] > 0) {
                winChars[rightChar - 'A'] = winChars[rightChar - 'A'] + 1;
            }
            if (isValid(chars, winChars) && (solution.isEmpty() || right - left + 1 < solution.length())) {
                solution = s.substring(left, right + 1);
            }
            String currentWindow = s.substring(left, right + 1);
            //Shrink window till window becomes invalid
            if (right - left >= subset.length()) { //Bug1: Needed to be >=, had set ==
                while (left < right && shouldWindowContract(chars, winChars)) {
                    currentWindow = s.substring(left, right + 1);
                    char leftChar = s.charAt(left);
                    //Increment left
                    if (chars[leftChar - 'A'] > 0) {
                        winChars[leftChar - 'A'] = winChars[leftChar - 'A'] - 1;
                    }
                    left++;
                    if (isValid(chars, winChars) && (solution.isEmpty() || right - left + 1 < solution.length())) {
                        solution = s.substring(left, right + 1);
                    }
                }
            }

        }
        return solution;
    }

    private static boolean shouldWindowContract(int[] c1, int[] c2) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != 0 && c2[i] < c1[i]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isValid(int[] c1, int[] c2) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
    */

    public static void main(String[] args) {
        //System.out.println("Result1: " + minWindow("ADOBECODEBANC", "ABC"));
        //System.out.println("Result2: " + minWindow("a", "a"));
        //System.out.println("Result3: " + minWindow("abc", "ac"));
        System.out.println("Result3: " + minWindow("acbbaca", "aba"));
    }

}
