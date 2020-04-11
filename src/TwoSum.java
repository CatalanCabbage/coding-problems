/**
 * @author Davis Jeffrey
 */

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: https://leetcode.com/problems/two-sum/
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * Assume that each input has exactly one solution; do not use the same element twice.
 */
public class TwoSum {

    //O(n*n)
    private static int[] findNumbersBrute(int[] numbers, int target) throws IllegalArgumentException {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No solution found in input Array");
    }

    //Not implemented, O(NlogN)
    private static int[] findNumbersSort(int[] numbers, int target) throws IllegalArgumentException {
        //Do sorting -- O(NlogN)
        int[] sortedNums = numbers;

        //Maintain 2 pointers p1 and p2, one from start, one from end -- O(n)
        int p2 = sortedNums.length - 1;
        for (int p1 = 0; p1 < sortedNums.length; p1++) {
            if (sortedNums[p1] + sortedNums[p2] > target) { //Sum > target, reduce sum
                p2--;
            } else if (sortedNums[p1] + sortedNums[p2] < target) { //Sum < target, increase sum
                p1++;
            } else {
                return new int[]{sortedNums[p1], sortedNums[p2]}; //Numbers found; but need to find indices again
            }
        }
        throw new IllegalArgumentException("No solution found in input Array");
    }

    //O(n)
    private static int[] findNumbersHashMap(int[] numbers, int target) throws IllegalArgumentException {
        Map<Integer, Integer> map = new HashMap<>(); //Key = number, Value = index
        int requiredNum;
        for (int i = 0; i < numbers.length; i++) {
            requiredNum = target - numbers[i];
            if(map.containsKey(requiredNum)) {
                return new int[]{i, map.get(requiredNum)};
            }
            else {
                map.put(numbers[i], i);
            }
        }
        throw new IllegalArgumentException("No solution found in input Array");
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] indices = findNumbersHashMap(numbers, target);
        System.out.println(numbers[indices[0]] + " + " + numbers[indices[1]] + " = " + target);
    }
}
