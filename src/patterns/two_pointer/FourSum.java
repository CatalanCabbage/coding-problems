/**
 * @author Davis Jeffrey
 */
package patterns.two_pointer;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target

 *
 * Notice that the solution set must not contain duplicates.
 *
 * Link: https://leetcode.com/problems/3sum/
 */

public class FourSum {
  List<List<Integer>> soln = new LinkedList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {   
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            while (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            threeSum(i + 1, nums, target - nums[i]);
        }
        return soln;
    }

    private void threeSum(int index, int[] nums, int target) {
        for (int i = index; i < nums.length - 2; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(i + 1, nums, target - nums[i], new int[]{nums[index], nums[i]});
        }
    }
    
    private void twoSum(int index, int[] nums, int target, int[] path) {
        int left = index;
        int right = nums.length - 1;
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum < target) {
                left++;
            } else if (currentSum > target) {
                right--;
            } else {
                List<Integer> temp = new LinkedList<>();
                temp.add(path[0]);
                temp.add(path[1]);
                temp.add(nums[left]);
                temp.add(nums[right]);
                soln.add(temp);
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
    }
}
