/**
 * @author Davis Jeffrey
 */
package patterns.two_heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares,
 * LeetCode would like to work on some projects to increase its capital before the IPO.
 * Since it has limited resources, it can only finish at most k distinct projects before the IPO.
 * Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 *
 * You are given n projects where the ith project has a pure profit profits[i]
 * and a minimum capital of capital[i] is needed to start it.
 *
 * Initially, you have `initialCapital` capital.
 * When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 *
 * Pick a list of at most `maxProjects` distinct projects from given projects to
 * maximize your final capital, and return the final maximized capital.
 *
 * The answer is guaranteed to fit in a 32-bit signed integer.
 *
 * Link: https://leetcode.com/problems/ipo/
 */

public class Ipo {
    public int findMaximizedCapital(int maxProjects, int initialCapital, int[] profits, int[] capital) {
        //Max-heap of profits, min-heap of capital.
        //When you can afford a capital, move it from min-heap Capital to max-heap Profit
        //Poll max-heap profit to get best bang for your buck and repeat

        //Note: Both heaps contain indices.
        Comparator<Integer> capitalComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return Integer.compare(capital[n1], capital[n2]);
            }
        };

        //Compare profits in reverse order, since maxHeap is needed
        Comparator<Integer> profitsComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return Integer.compare(profits[n2], profits[n1]);
            }
        };


        //Max-heap of profit
        PriorityQueue<Integer> maxProfits = new PriorityQueue<>(profitsComparator);

        //Min-heap of capital
        PriorityQueue<Integer> minCapital = new PriorityQueue<>(capitalComparator);

        for (int i = 0; i < capital.length; i++) {
            minCapital.add(i);
        }

        int maxCapital = initialCapital;
        for (int i = 0; i < maxProjects; i++) {
            //Put all applicable projects from capital heap in profits heap
            while (minCapital.size() > 0 && capital[minCapital.peek()] <= maxCapital) {
                maxProfits.add(minCapital.poll());
            }

            if (maxProfits.size() == 0) {
                break;
            }

            //Pick the top of profits heap as current project
            int projectIndex = maxProfits.poll();
            maxCapital = maxCapital + profits[projectIndex];

        }
        return maxCapital;

    }
}
