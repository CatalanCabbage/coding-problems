package patterns.merge_intervals;

import java.util.LinkedList;
import java.util.List;

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

class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> soln = new LinkedList<>();
        int index = 0;
        
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        
        //Add all intervals smaller than required
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            soln.add(intervals[index]);
            index++;
        }
        
    
        //Check if interval is overlapping
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            index++;
        }
        //Important to keep this outside, since if it does not overlap, actual newInterval will be added to soln anyway
        soln.add(newInterval); 
        
        //Add all intervals larger than required (remaining)
        while (index < intervals.length) {
            soln.add(intervals[index]);
            index++;
        }
      
        
        //Pointless conversion from list to array for this problem
        int[][] solnFfs = new int[soln.size()][];
        for (int i = 0; i < soln.size(); i++) {
            solnFfs[i] = soln.get(i);
        }
        return solnFfs;
    }
}
