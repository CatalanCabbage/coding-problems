/**
 * @author Davis Jeffrey
 */

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem:
 * You are given two integers n and k and two integer arrays speed and efficiency both of length n.
 * There are n engineers numbered from 1 to n.
 * speed[i] and efficiency[i] represent the speed and efficiency of the ith engineer respectively.
 * Choose at most k different engineers out of the n engineers to form a team with the maximum performance.
 *
 * The performance of a team is the sum of their engineers' speeds
 * multiplied by the minimum efficiency among their engineers.
 *
 * Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.
 *
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */

//https://www.youtube.com/watch?v=2FROyvnnrrM
class MaximumPerformanceOfATeam {
    //Sort by efficiency decreasing.
    //From the most efficient person, keep adding people one by one.
    //If group becomes too large, boot the slowest person out.
    public int maxPerformance(int n, int[] speed, int[] eff, int k) {
        long maxPerf = 0;
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = eff[i];
        }
        //Sort by efficiency decreasing.
        Arrays.sort(engineers, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long currentSpeedSum = 0;
        //From the most efficient person, keep adding people one by one.
        for (int i = 0; i < n; i++) {
            int currentSpeed = engineers[i][0];
            int efficiency = engineers[i][1];
            if (pq.size() == k) {
                currentSpeedSum -= pq.poll();
            }
            pq.add(currentSpeed); //Add speed of current engg to PQ
            currentSpeedSum += currentSpeed;

            maxPerf = Math.max(maxPerf, currentSpeedSum * efficiency);
        }

        System.out.println(maxPerf);
        return (int) (maxPerf % (int) (1e9 + 7L));
    }
}


