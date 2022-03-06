/**
 * Problem:
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 * Eg: Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 *
 * Link: https://leetcode.com/problems/max-area-of-island/
 */


class MaxAreaOfIsland {
    //Iterate
    //Bounds check
    //Mark visited
    //Visit
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int area = getMaxArea(grid, i, j, 0);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    private int getMaxArea(int[][] grid, int i, int j, int area) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return area;
        }
        if (grid[i][j] == 0) {
            return area;
        }

        if (grid[i][j] == 1) {
            area++;
            grid[i][j] = 0;
            area = getMaxArea(grid, i + 1, j, area);
            area = getMaxArea(grid, i - 1, j, area);
            area = getMaxArea(grid, i, j + 1, area);
            area = getMaxArea(grid, i, j - 1, area);
        }
        return area;
    }
}
