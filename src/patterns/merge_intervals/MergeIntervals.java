package patterns.merge_intervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * Eg: Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * <p>
 * Link: https://leetcode.com/problems/merge-intervals/
 */

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> soln = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length; i++) {
            //(i != intervals.length - 1) handles the last entry case - last entry needs to be added by default
            //Since there's nothing on its right to compare it with
            if (i != intervals.length - 1 && intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = intervals[i][0];
                if (intervals[i][1] > intervals[i + 1][1]) {
                    intervals[i + 1][1] = intervals[i][1];
                }
            } else {
                soln.add(intervals[i]);
            }

        }
        return soln.toArray(new int[soln.size()][]);
    }
}
