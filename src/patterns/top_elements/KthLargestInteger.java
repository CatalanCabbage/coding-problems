/**
 * @author Davis Jeffrey
 */
package patterns.top_elements;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given an array of strings nums and an integer k.
 * Each string in nums represents an integer without leading zeros.
 *
 * Return the string that represents the kth largest integer in nums.
 *
 * Note: Duplicate numbers should be counted distinctly.
 * For example, if nums is ["1","2","2"], "2" is the first largest integer,
 * "2" is the second-largest integer, and "1" is the third-largest integer.
 *
 * Link: https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
 */

public class KthLargestInteger {
    public String kthLargestNumber(String[] nums, int k) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() == b.length()) {
                    return b.compareTo(a);
                } else {
                    return b.length() > a.length() ? 1 : -1;
                }
            }
        };
        PriorityQueue<String> queue = new PriorityQueue<>(comparator);

        for (String num : nums) {
            queue.add(num);
        }

        System.out.print(queue);

        String soln = "";
        for (int i = 0; i < k; i++) {
            soln = queue.poll();
        }
        return soln;
    }
}
