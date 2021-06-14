/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * Eg: Input: String="araaci", K=2
 * Output: 4 //The longest substring with no more than '2' distinct characters is "araa".
 */

class LongestDistinctSubstring {
  public static int findLength(String str, int k) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    int left = -1;
    int right = -1;
    int longestLength = 0;
    int distinctChars = 0; //We can use HashMap's length too
    Map<Character, Integer> charsMap = new HashMap<>();
    //We use a hashMap to store chars that are there in the current window.
    while (right < str.length() - 1) {      
      right++;
      char rightChar = str.charAt(right);
      if (charsMap.containsKey(rightChar)) {
        charsMap.put(rightChar, charsMap.get(rightChar) + 1);
      } else {
        distinctChars++;
        charsMap.put(rightChar, 1);
      }
      while (distinctChars > k && left < right) {
        left++;
        char leftChar = str.charAt(left);
        //If the Map has a value > 1, it means that another occurrence of the same char is 
        //present somewhere else in the String too; so distinctChars stays the same.
        if (charsMap.get(leftChar) > 1) {
          charsMap.put(leftChar, charsMap.get(leftChar) - 1);
        } else {
          distinctChars--;
          charsMap.remove(leftChar);
        }
      }
      longestLength = (right - left) > longestLength ? (right - left) : longestLength; 
    }
    return longestLength;
  }
}
