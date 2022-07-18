import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Convert a non-negative integer num to its English words representation.
 *
 * Link: https://leetcode.com/problems/integer-to-english-words/
 *
 * Example:
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 *
 * Input: num = 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */

class IntegerToEnglishWords {
    private Map<Integer, String> legend = new HashMap<>();
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        init();
        String res = "";
        //How to get digit in a particular place?
        //321   : 321 / 100     = 3.2 = 3
        //4523  : 4523 / 1000   = 4.5 = 4

        //Generate billion (10 crores)
        if (num > 999_999_999) {
            res += getBillion(num);
            num = num % 1_000_000_000;
        }
        //Generate million (10 lakhs)
        if (num > 999_999) {
            res += getMillion(num);
            num = num % 1_000_000;
        }
        //Generate thousand
        if (num > 999) {
            res += getThousand(num);
            num = num % 1000;
        }
        //Generate hundred
        if (num > 99) {
            res += getHundred(num);
            num = num % 100;
        }
        //Generate tens
        if (num > 0) {
            res += getTen(num);
        }
        return res.trim();
    }

    private String getBillion(int num) {
        int billionsPart = num / 1_000_000_000;
        if (billionsPart == 0) {
            return "";
        } else {
            String res =   numberToWords(billionsPart) + " " + "Billion" + " ";
            return res;
        }
    }

    private String getMillion(int num) {
        int millionsPart = num / 1_000_000;
        if (millionsPart == 0) {
            return "";
        } else {
            String res = numberToWords(millionsPart) + " " + "Million" + " ";
            return res;
        }
    }

    private String getThousand(int num) {
        int thousandsPart = num / 1000;
        if (thousandsPart == 0) {
            return "";
        } else {
            String res = numberToWords(thousandsPart) + " " + "Thousand" + " ";
            return res;
        }
    }

    private String getHundred(int num) {
        int hundredsPart = num / 100;
        if (hundredsPart == 0) {
            return "";
        } else {
            String res = numberToWords(hundredsPart) + " " + "Hundred" + " ";
            return res;
        }
    }


    //Cases to try: 19, 25, 1, 0
    private String getTen(int num) {
        if (num == 0) {
            return "";
        } else if (num <= 20) {
            return legend.get(num);
        } else {
            int onesPart = num % 10;
            int tensPart = num - onesPart;
            String res = legend.get(tensPart) + " " + legend.get(onesPart);
            return res;
        }
    }


    private void init() {
        legend.put(0, "");
        legend.put(1, "One");
        legend.put(2, "Two");
        legend.put(3, "Three");
        legend.put(4, "Four");
        legend.put(5, "Five");
        legend.put(6, "Six");
        legend.put(7, "Seven");
        legend.put(8, "Eight");
        legend.put(9, "Nine");
        legend.put(10, "Ten");
        legend.put(11, "Eleven");
        legend.put(12, "Twelve");
        legend.put(13, "Thirteen");
        legend.put(14, "Fourteen");
        legend.put(15, "Fifteen");
        legend.put(16, "Sixteen");
        legend.put(17, "Seventeen");
        legend.put(18, "Eighteen");
        legend.put(19, "Nineteen");
        legend.put(20, "Twenty");
        legend.put(30, "Thirty");
        legend.put(40, "Forty");
        legend.put(50, "Fifty");
        legend.put(60, "Sixty");
        legend.put(70, "Seventy");
        legend.put(80, "Eighty");
        legend.put(90, "Ninety");
    }
}
