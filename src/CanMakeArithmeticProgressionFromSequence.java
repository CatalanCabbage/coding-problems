import java.util.Arrays;
import java.util.HashSet;

/**
 * Problem:
 * A sequence of numbers is called an arithmetic progression if
 * the difference between any two consecutive elements is the same.
 *
 * Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression.
 * Otherwise, return false.
 *
 * Link: https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
 */


class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

            set.add(arr[i]);
        }

        //This should be the diff between consecutive elements
        int diff = (max - min) / (arr.length - 1);

        //If an input has duplicates, the only way this is valid is if the diff is 0
        boolean hasDuplicates = arr.length != set.size();
        if (diff != 0 && hasDuplicates) {
            return false;
        }

        //If diff is 0, all elements should be the same, so set size should be 1
        if (diff == 0 && set.size() > 1) {
            return false;
        }


        for (int i = 0; i < arr.length; i++) {
            //Check if an element with the diff exists
            if (arr[i] != min && !set.contains(arr[i] - diff)) {
                return false;
            }
        }
        return true;
    }


    private boolean canMakeArithmeticProgressionSort(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        Arrays.sort(arr);
        int baseline = arr[0] - arr[1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] - arr[i] != baseline) {
                return false;
            }
        }
        return true;
    }
}
