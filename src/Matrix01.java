import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem:
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 *
 * Link: https://leetcode.com/problems/01-matrix/
 *
 * Eg: Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 */


class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        // For each cell:
        // if 0, need to process, add to queue.
        // if 1, no need to process but set as -1 (or max_value)

        // Then for each element, check 4 directions
        // If 0, nothing. If -1, set the distance and add it to queue

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] directions = new int[][] {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] currentElement = queue.poll();
                for (int j = 0; j < directions.length; j++) {
                    int newRow = currentElement[0] + directions[j][0];
                    int newCol = currentElement[1] + directions[j][1];
                    if (newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length ) {
                        if (mat[newRow][newCol] >= 0) {
                            continue;
                        } else {
                            mat[newRow][newCol] = mat[currentElement[0]][currentElement[1]] + 1;
                            queue.offer(new int[] {newRow, newCol});
                        }
                    }
                }
            }
        }
        return mat;
    }
}