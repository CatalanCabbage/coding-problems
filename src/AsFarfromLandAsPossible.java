import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem:
 * Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land,
 * find a water cell such that its distance to the nearest land cell is maximized,
 * and return the distance. If no land or water exists in the grid, return -1.
 *
 * The distance used in this problem is the Manhattan distance:
 * the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 *
 * Link: https://leetcode.com/problems/as-far-from-land-as-possible/
 *
 * Eg: Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
 */


class AsFarfromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int maxDist = -1;
        boolean isLandPresent = false;
        Queue<int[]> queue = new LinkedList<>();
        for(int i =0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 0;
                } else {
                    isLandPresent = true;
                    grid[i][j] = -1;
                }
            }
        }

        //Edge case: All water or all land
        if (!isLandPresent || queue.isEmpty()) {
            return maxDist;
        }

        int[][] directions = new int[][] {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };


        while (!queue.isEmpty()) {
            maxDist++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] currentCell = queue.poll();
                int row = currentCell[0];
                int col = currentCell[1];
                for (int j = 0; j < directions.length; j++) {
                    int newRow = row + directions[j][0];
                    int newCol = col + directions[j][1];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                        if (grid[newRow][newCol] > 0) {
                            continue;
                        } else {
                            grid[newRow][newCol] = grid[row][col] + 1;
                            queue.offer(new int[] {newRow, newCol});
                        }
                    }
                }
            }
        }
        return maxDist;
    }
}