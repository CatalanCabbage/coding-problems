import java.util.Arrays;

/**
 * Problem: You are given an array of intervals,
 * where intervals[i] = [starti, endi] and each starti is unique.
 *
 * The right interval for an interval i is an interval j such that startj >= endi
 * and startj is minimized. Note that i may equal j.
 *
 * Return an array of right interval indices for each interval i.
 * If no right interval exists for interval i, then put -1 at index i.
 *
 * Link: https://leetcode.com/problems/find-right-interval/
 *
 * Times: 1
 * Rating: 2
 */


class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        //Make array with starting time and index
        //Sort by starting time
        //For each ending time, binary search
        int[][] starts = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        //printArr(starts, "Starts");

        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));
        //printArr(starts, "Starts sorted");

        int[] solution = new int[intervals.length];

        for (int i = 0; i < solution.length; i++) {
            int target = intervals[i][1];
            //Binary search for start value closest and greater than target
            int hi = starts.length - 1;
            int lo = 0;
            int mid = 0;
            solution[i] = -1;

            while (lo <= hi) {
                mid = hi - ((hi - lo) / 2);
                int currentStart = starts[mid][0];
                if (currentStart == target) {
                    solution[i] = starts[mid][1];
                    break;
                } else if (currentStart < target) {
                    lo = mid + 1;
                } else {
                    solution[i] = starts[mid][1];
                    hi = mid - 1;
                }
            }
        }
        return solution;
    }
}
