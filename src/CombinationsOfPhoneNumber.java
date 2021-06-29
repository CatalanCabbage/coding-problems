import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem:
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Digits are mapped to letters in the Telephone keypad (2 is "abc", 3 is "def", etc)
 * <p>
 * Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

class CombinationsOfPhoneNumber {
    List<String> list = new ArrayList<>();
    String digits;

    public List<String> letterCombinations(String digitsStr) {
        if (digitsStr.isEmpty()) {
            return list;
        }
        digits = digitsStr;
        generateCombinations(0, "");
        return list;
    }

    //For every digit, add one char and generate combinations for the rest
    private void generateCombinations(int digitIndex, String currentStr) {
        if (digitIndex == digits.length()) {
            list.add(currentStr);
            return;
        }

        //Add a dummy "" to convert char to String
        String chars = getCharsForDigit(digits.charAt(digitIndex) + "");
        for (int i = 0; i < chars.length(); i++) {
            generateCombinations(digitIndex + 1, currentStr + chars.charAt(i));
        }
    }

    private String getCharsForDigit(String digit) {
        Map<String, String> charsMap = new HashMap<>();
        charsMap.put("2", "abc");
        charsMap.put("3", "def");
        charsMap.put("4", "ghi");
        charsMap.put("5", "jkl");
        charsMap.put("6", "mno");
        charsMap.put("7", "pqrs");
        charsMap.put("8", "tuv");
        charsMap.put("9", "wxyz");

        return charsMap.get(digit);
    }
}
