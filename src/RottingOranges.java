/**
 * @author Davis Jeffrey
 */

import java.util.ArrayDeque;

/**
 * Problem:
 * You are given an m x n grid where each cell can have one of three values:
 *
 *     0 representing an empty cell,
 *     1 representing a fresh orange, or
 *     2 representing a rotten orange.
 *
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1.
 *
 * Link: https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        //For each rotten orange, mark adjacent as rotten and mark this as empty
        //Add all adjacent to a queue
        //do this while queue isn't empty
        //In the end iterate and check if there are any fresh oranges
        ArrayDeque<Integer[]> queue = new ArrayDeque<>();
        int totalFreshOranges = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Integer[]{i, j});
                } else if (grid[i][j] == 1) {
                    totalFreshOranges++;
                }
            }
        }

        //2 1 1
        //1 1 0
        //0 1 1
        int depth = 0;
        //This runs while there are rotten oranges
        while (!queue.isEmpty()) {
            //Check first before incrementing depth, since it's possible that there are rotten oranges
            //that haven't been visited yet, but the board is solved. Eg: [[0, 2][0, 0]]
            if (totalFreshOranges == 0) {
                return depth;
            }

            //System.out.println("Queue at depth " + depth + ": " + Arrays.toString(queue.toArray()));
            int queueSize = queue.size();
            depth++;
            for (int i = 0; i < queueSize; i++) {
                //Mark adjacent as rotten
                Integer[] currentOrange = queue.poll();
                int markedOranges = markAdjacent(currentOrange, grid, queue);
                totalFreshOranges -= markedOranges;
            }
        }

        return totalFreshOranges == 0 ? depth : -1;
    }

    private int markAdjacent(Integer[] currentOrange, int[][] grid, ArrayDeque<Integer[]> queue) {
        int markedOranges = 0;
        int row = currentOrange[0];
        int col = currentOrange[1];

        //Mark current as 0
        grid[row][col] = 0;

        //Mark adjacent, add to queue
        //Top
        if (row > 0 && grid[row - 1][col] == 1) {
            queue.add(new Integer[]{row - 1, col});
            grid[row - 1][col] = 2;
            markedOranges++;
        }
        //Right
        if (col < grid[0].length - 1 && grid[row][col + 1] == 1) {
            queue.add(new Integer[]{row, col + 1});
            grid[row][col + 1] = 2;
            markedOranges++;
        }
        //Bottom
        if (row < grid.length - 1 && grid[row + 1][col] == 1) {
            queue.add(new Integer[]{row + 1, col});
            grid[row + 1][col] = 2;
            markedOranges++;
        }
        //Left
        if (col > 0 && grid[row][col - 1] == 1) {
            queue.add(new Integer[]{row, col - 1});
            grid[row][col - 1] = 2;
            markedOranges++;
        }
        return markedOranges;
    }
}
