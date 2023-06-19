/**
 * Problem:
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 *     [4,5,6,7,0,1,2] if it was rotated 4 times.
 *     [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 *
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */


class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {

        // - Condition: while(lo <= hi)
        // - Calc mid:  mid = lo + (hi - lo) / 2
        // - if (target > nums[mid]) lo = mid + 1
        // - if (target < nums[mid]) hi = mid - 1

        int res = nums[0];
        int lo = 0, hi = nums.length-1;

        //5 1 2 3 4
        //5 6 7 8 9 1

        //traverse
        while(lo<=hi){
            //This means the full array in focus is sorted, just return the first value.
            if(nums[lo] < nums[hi]){
                res = Math.min(res, nums[lo]);
                break;
            }
            int mid = (lo+hi) / 2;
            res = Math.min(res, nums[mid]);

            //We know number isn't sorted.
            //If number in the middle is greater than the start of the array, (5 6 7 1)
            //7 > 5: then it means that the ACTUAL starting should be after the middle part.
            if(nums[mid] >= nums[lo]){
                lo = mid+1;
            }
            else{
                //If number in the middle is smaller than the start of the array (5 1 2 3),
                //2 < 5: then it means the ACTUAL starting is before 2
                hi = mid-1;
            }
        }
        return res;
    }
}
