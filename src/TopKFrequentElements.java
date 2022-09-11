import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Problem:
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Link: https://leetcode.com/problems/top-k-frequent-elements/
 */


class TopKFrequentElements {

    public static void main(String[] args) {
        int[] outputArr = topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        return;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numsMap.merge(nums[i], 1, (a, b) -> a + b);
        }

        return numsMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).map(Map.Entry::getKey).limit(k).mapToInt(x -> x).toArray();
//        List<Map.Entry<Integer, Integer>> keysList = new ArrayList<>(numsMap.entrySet());
//        keysList.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
//        // numsMap.sort((a, b) -> Integer.compare(numsMap.getOrDefault(b, 0), numsMap.getOrDefault(a, 0)));
//
//        int[] result = new int[k];
//        for (int i = 0; i < k; i++) {
//            result[i] = keysList.get(i).getKey();
//        }
//
//
//        return result;

    }
}
