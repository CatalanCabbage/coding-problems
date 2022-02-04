/**
 * @author Davis Jeffrey
 */
package patterns.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence
 * by deleting some or no elements without changing the order of the remaining elements.
 *
 * Link: https://leetcode.com/problems/longest-palindromic-subsequence/
 */

public class LongestPalindromicSubsequence {
    static int[][] db;
    private static int findLongestSubseqRec(String str) {
        db = new int[str.length()][str.length()];
        return findLongestSubseqRec(str.toCharArray(), 0, str.length() - 1);
    }

    private static int findLongestSubseqRec(char[] chars, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return 1;
        }
        if (db[left][right] != 0) {
            return db[left][right];
        }
        //Check if current left and right are same and increment count
        //If not, try skipping left and right
        if (chars[left] == chars[right]) {
            db[left][right] = 2 + findLongestSubseqRec(chars, left + 1, right - 1);
        } else {
            db[left][right] = Math.max(findLongestSubseqRec(chars, left + 1, right),
                findLongestSubseqRec(chars, left, right - 1));
        }
        return db[left][right];
    }

//       c d d p d
//    c |1|0|0|0|0|
//    d |0|1|0|0|0|
//    d |0|0|1|0|0|
//    p |0|0|0|1|0|
//    d |0|0|0|0|1|
    private static int findLongestSubseqIter(String s) {
        //Eg.Input: "bbbab"
        //DB is basically the answers to each combination of inputs.
        //db[startIndex][endIndex]
        //"bbb" will be db[0][2], "bba" will be db[1][3] etc
        int[][] db = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            //Longest palindrome subseq of 1 character is 1. Eg: db[2][2], "b"
            db[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    //If db[startIndex] == db[endIndex], it means this contributes to the palindrome by 2.
                    //Eg: db[1][4] is "bbab" and there's "b" at both start and end.
                    //So longest palindrome is:
                    // = 2 + valueOf(middle letters) = 2 + valueOf("ba")
                    // = 2 + db[1 + 1][4 - 1] = 2 + db[2][3]
                    db[i][j] = db[i+1][j-1] + 2;
                } else {
                    //If start and end letters don't match, this doesn't contribute to the palindroms.
                    //Try skipping start or end and take whichever's greater.
                    db[i][j] = Math.max(db[i+1][j], db[i][j-1]);
                }
                //print2dArray(db);
            }
        }
        //In the end, our goal is to get the largest sequence of the whole string,
        //so take db[firstChar][lastChar]
        return db[0][s.length()-1];
    }

    private static void print2dArray(int[][] array) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("x | ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(i + " | ");
        }
        System.out.println();

        for(int i = 0; i < array.length; i++) {
            System.out.print(i + " | ");
            for(int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
        System.out.println();
    }

    @Test
    @DisplayName("Find longest substring recursively")
    void isValidRecursion() {
        Assertions.assertAll(() -> assertEquals(4, findLongestSubseqRec("bbbab")),
            () -> assertEquals(2, findLongestSubseqRec("cbbd")));
    }

    @Test
    @DisplayName("Find longest substring iteratively")
    void isValidIteration() {
        Assertions.assertAll(() -> assertEquals(4, findLongestSubseqIter("bbbab")),
            () -> assertEquals(2, findLongestSubseqIter("cbbd")));
    }
}
