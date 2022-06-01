package patterns.merge_intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane.
 * The balloons are represented as a 2D integer array points where
 * points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend.
 * You do not know the exact y-coordinates of the balloons.
 *
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
 * A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend.
 * There is no limit to the number of arrows that can be shot.
 * A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 *
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 *
 * Eg: Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 * 
 * Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
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


    public int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        int count = 0;
        //Sort the points by start time
        //Keep endTime of first point as max limit
        //Keep adding balloons till next(startTime) > min(endTime)
        //(1,2) (1,1) (1,4) (2,3) (2,6) (3,3)
        //[[1,2],[2,3],[3,4],[4,5]]
        //Invariant: Start time of current balloon can't be more than end of next time.

        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < points.length; i++) {
            //Keep arrow at min(xend)
            //Keep moving to the right
            //If xstart of next < min(xend), move arrow to xstart of next
            //If xend of next < current min xend, save this
            //Else save the current arrow and move to the next.

            //This xArrow is actually not needed!
            int xArrow = points[i][0];
            int minEnd = points[i][1];
            while (i < points.length - 1 && points[i + 1][0] <= minEnd) {
                i++;
                minEnd = Math.min(points[i][1], minEnd);
                xArrow = Math.max(xArrow, points[i][0]);
            }
            count++;
        }
        return count;
    }
}
