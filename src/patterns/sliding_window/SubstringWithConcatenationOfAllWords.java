/**
 * @author Davis Jeffrey
 */
package patterns.sliding_window;

import java.util.LinkedList;
import java.util.List;

/**
 * You are given a string s and an array of strings words of the same length.
 * Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once,
 * in any order, and without any intervening characters.
 * You can return the answer in any order.
 * <p>
 * Eg: Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9] //Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * <p>
 * Link: https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */

public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> solution = new LinkedList<>();
        return solution;
    }

    public static void main(String[] args) {
        System.out.println("Result1 " + findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println("Expected: [0,9]");
        System.out.println("Result2 " + findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println("Expected: []");
        System.out.println("Result3 " + findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println("Expected: [6,9,12]");

    }

}
