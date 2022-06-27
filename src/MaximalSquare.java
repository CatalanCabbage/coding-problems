import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given an m x n binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 *
 * Link: https://leetcode.com/problems/maximal-square/
 *
 * Times: 1
 * Rating: 0
 */


class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        //https://leetcode.com/problems/maximal-square/discuss/600149/Python-Thinking-Process-Diagrams-DP-Approach
        int[][] db = new int[matrix.length + 1][matrix[0].length + 1];
        int maxLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int dbRow = i + 1;
                int dbCol = j + 1;
                //Basically take the min value of (top, left and top-left) + 1 as current value
                //Because the size of this square depends on those 3. Even if one of them is less,
                //that'll be the max size possible with this square
                db[dbRow][dbCol] = Math.min(db[dbRow - 1][dbCol], db[dbRow][dbCol - 1]);
                db[dbRow][dbCol] = Math.min(db[dbRow - 1][dbCol - 1], db[dbRow][dbCol]);
                db[dbRow][dbCol] += 1;
                maxLen = Math.max(db[dbRow][dbCol], maxLen);
            }
        }
        return maxLen * maxLen;
    }
}
