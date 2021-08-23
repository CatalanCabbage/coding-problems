import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 * You're given the startTime, endTime and profit arrays,
 * return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 *
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 *
 * Eg: Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job.
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 *
 * Link: https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 */


class MaximumProfitInJobScheduling {
    Map<Integer, Integer> dp = new HashMap<>();
    int length;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        length = startTime.length;
        int[][] jobs = new int[length][3];

        for (int i = 0; i < length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        //At this point, array is sorted by start time.
        //Each job has [start, end, profit].

        return getMaxProfit(0, jobs);
    }

    private int getMaxProfit(int current, int[][] jobs) {
        if (current == length) {
            return 0;
        }
        if (dp.containsKey(current)) {
            return dp.get(current);
        }

        //2 ways this can go.
        //1: Include current job == this job's profit + sum(profits from next non-overlapping job)
        //2: Exclude current job == sum(profits from immediate next job)
        int nextPossibleJob = getNextJob(current, jobs);
        int includedProfit = jobs[current][2] + (nextPossibleJob == -1? 0 : getMaxProfit(nextPossibleJob, jobs));
        int excludedProfit = getMaxProfit(current + 1, jobs);

        int maxCase = Math.max(includedProfit, excludedProfit);
        dp.put(current, maxCase);
        return maxCase;
    }

    private int getNextJob(int current, int[][] jobs) {
        int nextJob = -1;
        for (int next = current + 1; next < length; next++) {
            if (jobs[next][0] >= jobs[current][1]) {
                return next;
            }
        }
        return nextJob;
    }
}
