package patterns.merge_intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * 
 * Link: https://leetcode.com/problems/insert-interval/
 */

class MinimumNumberOfArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        //Sort in ascending order
        Arrays.sort(points, (p1, p2) -> Integer.compare(p1[0], p2[0]));

        int count = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            //Can the current arrow pop another balloon along with the current?
            if (points[i][0] <= end) {
                //Case: [[0,100], [40,60], [70,80]]:
                //end is 100 initially. 40 < 100, we can pop the second balloon too.
                //But now when we check if we can pop a third balloon, end should be taken as 60, not 100
                //in order to include the second balloon.
                end = Math.min(end, points[i][1]);
                continue;
            } else {
                //Next balloon can't be popped with current. Increment count and repeat.
                count++;
                end = points[i][1];
            }
        }

        return count;
    }
}
