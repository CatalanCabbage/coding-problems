/**
 * @author Davis Jeffrey
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/number-of-islands/
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * 7.65%, 5.12%
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        NumberOfIslands islands = new NumberOfIslands();
        int[][] inputArr = {{0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 1, 1, 0}};
        int[][] inputArr2 = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        int num = islands.findNumberOfIslands(inputArr2);
    }


    private int findNumberOfIslands(int[][] inpArr2D) {
        initUF(inpArr2D);
        parseInput(inpArr2D);
        countDistinctRoots(parents);
        return islands;
    }

    private int islands;
    private int inpArr[];
    private int parents[]; //Holds parent indices of 2d array as 1d array
    private int weights[];
    private int rows;
    private int cols;

    //Implement using weighted Union-Find trees
    private void initUF(int[][] inpArr2D) {
        islands = 0;
        rows = inpArr2D.length;
        cols = inpArr2D[0].length; //Assuming 2d array is not jagged
        int n = rows * cols + 1; //Leaving index 0 empty, so int arrays with n + 1
        parents = new int[n];
        weights = new int[n];
        inpArr = new int[n];
    }

    private void parseInput(int[][] inpArr2D) {
        int k = 1;  //For inpArr(1D equivalent of inpArr2d); leaving index 0 empty
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (inpArr2D[i][j] == 1) {
                    inpArr[k] = 1; //mark grid as island
                    parents[k] = k;
                    connectToAdjacentGrids(k);
                }
                k++;
            }
        }
    }

    private void connectToAdjacentGrids(int index) {
        int adjIndex;
        //Check if it's not left edge
        if (!(index % cols == 1) && parents[index - 1] != 0) {
            connect(index, index - 1);
        }
        //Check if it's not right edge
        if (!(index % cols == 0) && parents[index + 1] != 0) {
            connect(index, index + 1);
        }
        //Check if it's not top
        if (!(index <= cols) && parents[index - cols] != 0) {
            connect(index, index - cols);
        }
        //Check if it's not bottom
        if (!(index > (rows - 1) * cols) && parents[index + cols] != 0) {
            connect(index, index + cols);
        }
    }

    private void connect(int index1, int index2) {
        if(parents[index1] == 0) {
            parents[index1] = index1;
        } else if (parents[index2] == 0) {
            parents[index2] = index2;
        }
        if (weights[index1] > weights[index2]) {
            parents[root(index2)] = parents[root(index1)];
            weights[root(index2)] += weights[root(index1)];
        } else {
            parents[root(index1)] = parents[root(index2)];
            weights[root(index1)] += weights[root(index2)];
        }
    }

    private int root (int index) {
        while (index != parents[index]) {
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }

    //Here, distinct roots = distinct islands
    private void countDistinctRoots(int[] parents) {
        int temp;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parents.length; i++) {
            if(parents[i] == 0) {
                continue;
            }
            temp = root(parents[i]);
            if (!set.contains(temp)) {
                set.add(root(parents[i]));
                islands++;
            }
        }
    }
}
