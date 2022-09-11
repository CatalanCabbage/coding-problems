import java.util.Arrays;

/**
 * Problem:
 * You are playing a game that contains multiple characters,
 * and each of the characters has two main properties: attack and defense.
 * You are given a 2D integer array properties where properties[i] = [attacki, defensei]
 * represents the properties of the ith character in the game.
 *
 * A character is said to be weak if any other character has both attack and defense levels
 * strictly greater than this character's attack and defense levels.
 * More formally, a character i is said to be weak if there exists another character j
 * where attackj > attacki and defensej > defensei.
 *
 * Return the number of weak characters.
 *
 * Link: https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
 */


class TheNumberOfWeakCharactersInTheGame {
    public int numberOfWeakCharacters(int[][] properties) {
        int numOfChars = 0;

        //Sort by attack ascending
        //[1,3] [1,2] [1,1] [2,3]
        //   x   3      3     3
        Arrays.sort(properties, (a, b) ->
            Integer.compare(a[0], b[0]) == 0 ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        //For each element, check if any next values have defence greater than current

        int max = Integer.MIN_VALUE;
        for (int i = properties.length - 1; i >= 0; i--) {
            max = Math.max(max, properties[i][1]);
            if (properties[i][1] < max) {
                numOfChars++;
            }
        }

        return numOfChars;
    }
}
