import java.util.HashMap;

/**
 * Problem:
 * WYou are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security systems connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Eg: Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Link: https://leetcode.com/problems/house-robber/
 */


class HouseRobber {
    HashMap<Integer, Integer> dp = new HashMap<>();
    int[] nums;

    public int rob(int[] nums) {
        this.nums = nums;
        return getMax(0);
    }

    private int getMax(int current) {
        if (current >= nums.length) {
            return 0;
        }

        if (dp.containsKey(current)) {
            return dp.get(current);
        }

        //2 choices:
        //Skip this house, hit the next immediate one
        //Hit this house, hit n + 2 next
        int excluded = getMax(current + 1);
        int included = nums[current] + getMax(current + 2);

        int maxPossibleProfit = Math.max(included, excluded);
        dp.put(current, maxPossibleProfit);
        return maxPossibleProfit;
    }
}
