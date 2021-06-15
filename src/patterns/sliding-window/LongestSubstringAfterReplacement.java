/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, 
 * find the length of the longest substring having the same letters after replacement.
 *
 * Eg: Input: String="aabcabb", K=2
 * Output: 5 //Replace the 'c' and 'a' with 'b' to have a longest repeating substring "bbbbb".
 *
 * Solution: Basic intuition is - find the char repeated most times; remaining chars in the window can be replaced.
 * So when we have the max occurrences of a single char in the window(maxOccurrences), 
 * the chars to be replaced = sizeOfWindow - maxOccurrences <= k.
 */

class LongestSubstringAfterReplacement {
  public static int findLength(String str, int k) {
    if (str == null || str.isEmpty()) {
      return 0;
    }
    System.out.println("String: " + str);
    int maxLength = 0;
    Map<Character, Integer> currentCharsMap = new HashMap<>();
    int maxOccurrences = 0;
    int right = -1;
    int left = -1;

    //Till window expands till the end
    while (right < str.length() - 1) {
      right++;
      char currentChar = str.charAt(right);
      currentCharsMap.put(currentChar, currentCharsMap.getOrDefault(currentChar, 0) + 1);
      //Keep tracking the char with max occurrences
      if (currentCharsMap.get(currentChar) > maxOccurrences) {
        maxOccurrences = currentCharsMap.get(currentChar);
      }
      //Shrink window left till the letters to be replaced become == k 
      while ((right - left) - currentCharsMap.get(currentChar) > k && left < right) {
        left++;
        currentChar = str.charAt(left);
        currentCharsMap.put(currentChar, currentCharsMap.get(currentChar) - 1);
        //Update new max, in case the element that was removed to the left was the old max
        if (currentCharsMap.get(currentChar) > maxOccurrences) {
          maxOccurrences = currentCharsMap.get(currentChar);
        }
      }
      if (right - left + 1 > maxLength) {
        maxLength = right - left + 1; //+ 1 since the left'th element is also a part of the string
      }
    }
    return maxLength;
  }
}
