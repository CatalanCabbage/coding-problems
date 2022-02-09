/**
 * @author Davis Jeffrey
 */
package patterns.two_heaps;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.TreeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is
 * unique.
 *
 * The right interval for an interval i is an interval j such that startj >= endi and startj is
 * minimized.
 *
 * Return an array of right interval indices for each interval i. If no right interval exists for
 * interval i, then put -1 at index i.
 *
 * Link: https://leetcode.com/problems/find-right-interval/
 */

public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        //Put everything in a treeMap by startTime
        TreeMap<Integer, Integer> intervalsMap = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            intervalsMap.put(intervals[i][0], i);
        }
        //For each entry's endTime, check treeMap for ceil and return
        for (int i = 0; i < result.length; i++) {
            Integer ceilKey = intervalsMap.ceilingKey(intervals[i][1]);
            result[i] = ceilKey == null ? -1 : intervalsMap.get(ceilKey);
        }
        return result;
    }

    private static void print2dArray(int[][] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print("[");
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.print("],");
        }
    }

    @Test
    @DisplayName("Check if right intervals are right")
    void isValid() {
        int[][] tc1 = new int[][]{
            new int[]{3, 4},
            new int[]{2, 3},
            new int[]{1, 2}
        };
        int[][] tc2 = new int[][]{
            new int[]{1, 4},
            new int[]{2, 3},
            new int[]{3, 4}
        };

        Assertions.assertAll(() -> assertArrayEquals(new int[]{-1, 0, 1}, findRightInterval(tc1)),
            () -> assertArrayEquals(new int[]{-1, 2, -1}, findRightInterval(tc2)));
    }
}
