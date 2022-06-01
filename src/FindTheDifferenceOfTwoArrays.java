import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Problem:
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 *
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 *
 * Note that the integers in the lists may be returned in any order.
 *
 * Link: https://leetcode.com/problems/find-the-difference-of-two-arrays/
 */


class FindTheDifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] arr1, int[] arr2) {
        Set<Integer> s1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(arr2).filter(num -> !s1.contains(num)).boxed()
            .collect(Collectors.toSet());
        Arrays.stream(arr2).forEach(s1::remove);
        return Arrays.asList(new ArrayList<>(s1), new ArrayList<>(s2));
    }
}
