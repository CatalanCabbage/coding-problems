import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product
 * of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 */
class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int totalProduct = 1;
        int zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
            }
            totalProduct = totalProduct * nums[i];
        }

        //Case 1: There are multiple 0s. Result is all 0s.
        if (zeroes > 1) {
            return result;
        } if (zeroes == 1) {
            //Case 2: There is 1 0, so there's only 1 non-zero entry in result array
            totalProduct = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    //Find product
                    for (int j = 0; j < nums.length; j++) {
                        if (i == j) {
                            continue;
                        }
                        totalProduct = totalProduct * nums[j];
                    }
                    result[i] = totalProduct;
                }
            }
        } else {
            //Normal op
            for (int i = 0; i < nums.length; i++) {
                result[i] = totalProduct / nums[i];
            }
        }
        return result;
    }
}
