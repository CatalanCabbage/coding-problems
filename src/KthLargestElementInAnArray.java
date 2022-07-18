import java.util.Arrays;
import java.util.Random;

/**
 * Problem:
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Times: 1
 * Rating: 2
 */

class KthLargestElementInAnArray {
    //https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/2180600/A-Guide-to-Quick-Select-or-JAVA
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];

        //pIndex can be just left or right as well, but we choose a random number to
        //reduce chances of hitting the worst case.
        //With pIndex = right: 21ms, with pIndex = random: 2ms.
        int pIndex = new Random().nextInt(right - left + 1) + left;
        pIndex = partition(nums, left, right, pIndex);

        //Our pivot was the kth largest element
        if (pIndex == k) {
            return nums[k];
        } else if (pIndex < k) {
            //Our pivot is less than the position we want, so look to its right
            return quickSelect(nums, pIndex + 1, right, k);
        } else {
            return quickSelect(nums, left, pIndex - 1, k);
        }
    }

    //Partition nums from left to right, such that pIndex is in the correct index.
    private int partition(int[] nums, int left, int right, int pIndex) {
        int pivot = nums[pIndex];
        //Move our element to the end
        swap(nums, pIndex, right);
        pIndex = left;

        for (int i = left; i <= right; i++) {
            //If any element is smaller than pivot, move it to its left.
            if (nums[i] <= pivot) {
                swap(nums, i, pIndex);
                pIndex++;
            }
        }
        return pIndex - 1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }



    //Obvious solution
    public int findKthLargestSorting(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
