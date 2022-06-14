/**
 * Problem:
 * You are given a list of integers nums of length n representing the current score of swimmers in a competition.
 * There is one more round to swim and the first place winner for this round gets n points, second place n-1 points, etc. and the last place gets 1 point.
 * Return the number of swimmers that can still win the competition after the last round. If you tie for first in points, this still counts as winning.
 * <p>
 * Link: https://binarysearch.com/problems/Win-After-Last-Round
 * <p>
 * Solution:
 * 1. Find the lowest possible winning score (threshold).
 * 2. Count the number of people who can equal or exceed that threshold if placed first.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegexTest {
    public static void main(String[] args) {
        checkMatches();
        getQuote();
        split();
    }

    private static void split() {
        //Ignore punctuation and split
        String[] words = "That's what she said".replaceAll("[^\\w\\s]", "").split(" ");
        System.out.println(Arrays.asList(words));
    }
    private static void getQuote() {
        String target = "That's what she said";
        String quotedRegex = Pattern.quote(target);
        System.out.println(quotedRegex);
        System.out.println(Pattern.matches(quotedRegex, target));
    }

    private static void checkMatches() {
        String target = "That's what she said";
        Pattern pattern = Pattern.compile("^that\'s[\\w\\s]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(target);
        boolean doesItMatch = matcher.matches();
        System.out.println(doesItMatch);

        //To skip persistence of Pattern, we can also do:
        boolean b = Pattern.matches("^that\'s.*", target);
    }
}
