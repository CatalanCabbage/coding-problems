/**
 * Given two strings s1 and s2, return true if s2 contains the permutation of s1.
 * In other words, one of s1's permutations is the substring of s2.
 * 
 * Eg: Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true (s2 contains one permutation of s1 ("ba")).
 *
 * Link: https://leetcode.com/problems/permutation-in-string/
 */

class PermutationInString {    
    //Check the next method for comments
    public boolean checkInclusion(String s1, String str) {
        if (s1.length() > str.length()) {
            return false;
        }
        
        //This Map contains the chars and their occurrences needed to form a permutation
        //Whenever a required char enters/leaves the window, update the count of that char
        //If at any point the count of all chars in this map is 0, then our permutation has been found
        Map<Character, Integer> reqChars = new HashMap<>();
        for (char c : s1.toCharArray()) {
            reqChars.put(c, reqChars.getOrDefault(c, 0) + 1);
        }
        
        int right = -1;
        int left = 0;
        
        //This is the number of chars in the current window whose counts match our required counts exactly. 
        //Hence, if at ay point matchingChars == reqChars.size(), it means that all chars' counts match, 
        //and our permutation has been found.
        int matchingChars = 0;
        
        while (right < str.length() - 1) {
            //No need to shorten the window (do left++) if the current window != the size of our required string
            if (right - left + 1 == s1.length()) {             
                //If the char in `left` is part of our permutation, update the count.
                if (reqChars.containsKey(str.charAt(left))) {
                    reqChars.put(str.charAt(left), reqChars.get(str.charAt(left)) + 1);
                    //Since `left` is leaving the window: if it previously matched but doesn't match after the update,
                    //Decrement matchingChars
                    if (reqChars.get(str.charAt(left)) == 1) {
                        matchingChars--;
                    }
                }
                left++;
            }
            right++;
            //If the char in `right` is part of our permutation, update the count.
            if (reqChars.containsKey(str.charAt(right))) {
                reqChars.put(str.charAt(right), reqChars.get(str.charAt(right)) - 1);
                //Since `left` is entering the window: if it matches the count after the update,
                //increment matchingChars
                if (reqChars.get(str.charAt(right)) == 0) {
                    matchingChars++;
                }
            }
            //Of course, if x chars match (matchingChars) and x chars need to match (reqChars.size()), it's done.
            if (matchingChars == reqChars.size()) {
                return true;
            }
        }
        return false;
    }
    
    //Same as above, but isValid is simpler and more expensive - checks the Map each iteration.
    public boolean checkInclusionOld(String s1, String str) {
        if (s1.length() > str.length()) {
            return false;
        }
        Map<Character, Integer> reqChars = new HashMap<>();
        for (char c : s1.toCharArray()) {
            reqChars.put(c, reqChars.getOrDefault(c, 0) + 1);
        }
        int right = -1;
        int left = 0;
        while (right < str.length() - 1) {
            if (right - left + 1 == s1.length()) {                
                //Add left to map
                if (reqChars.containsKey(str.charAt(left))) {
                    reqChars.put(str.charAt(left), reqChars.get(str.charAt(left)) + 1);
                }
                left++;
            }
            right++;
            if (reqChars.containsKey(str.charAt(right))) {
                reqChars.put(str.charAt(right), reqChars.get(str.charAt(right)) - 1);
            }
            boolean isValid = true;
            for (char c : reqChars.keySet()) {
                if (reqChars.get(c) != 0) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return true;
            }
        }
        return false;
    }
}
