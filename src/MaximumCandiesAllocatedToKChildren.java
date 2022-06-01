import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Problem:
 * You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of size candies[i].
 * You can divide each pile into any number of sub piles, but you cannot merge two piles together.
 * You are also given an integer k.
 * You should allocate piles of candies to k children such that each child gets the same number of candies.
 * Each child can take at most one pile of candies and some piles of candies may go unused.
 *
 * Return the maximum number of candies each child can get.
 *
 * Link: https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
 *
 * Eg. Input: candies = [5,8,6], k = 3
 * Output: 5
 * Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] into 2 piles of size 5 and 1.
 * We now have five piles of candies of sizes 5, 5, 3, 5, and 1. We can allocate the 3 piles of size 5 to 3 children.
 * It can be proven that each child cannot receive more than 5 candies.
 */


class MaximumCandiesAllocatedToKChildren {
    public static int maximumCandies(int[] candies, long children) {
        int maxCandies = 0;

        int hi = Arrays.stream(candies).reduce(0, Integer::max);
        int lo = 1;
        int mid = lo + (hi - lo) / 2; //Current pile size

        while (lo <= hi) {
            if (isDistributionPossible(candies, children, mid)) {
                //Distribution is possible, save current size and increase pile size
                maxCandies = mid;
                lo = mid + 1;
                mid = lo + (hi - lo) / 2;
            } else {
                //Distribution is not possible, decrease pile size
                hi = mid - 1;
                mid = lo + (hi - lo) / 2;
            }
        }
        return maxCandies;
    }

    private static boolean isDistributionPossible(int[] candies, long children, int pileSize) {
        long childrenRemaining = children;
        for (int i = 0; (i < candies.length) && childrenRemaining > 0; i++) {
            childrenRemaining = childrenRemaining - (candies[i] / pileSize);
        }
        return childrenRemaining <= 0;
    }

    @Test
    @DisplayName("IsValid")
    void isValid() {
        assertEquals(0, maximumCandies(new int[]{1,2,3}, 100));
        assertNotEquals(0, maximumCandies(new int[]{1,2,3}, 1));
    }
}
