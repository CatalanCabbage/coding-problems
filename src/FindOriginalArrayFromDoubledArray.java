/**
 * @author Davis Jeffrey
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem:
 * An integer array original is transformed into a doubled array changed by appending
 * twice the value of every element in original, and then randomly shuffling the resulting array.
 * Given an array changed, return original if changed is a doubled array.
 * If changed is not a doubled array, return an empty array.
 * The elements in original may be returned in any order.
 *
 * Link: https://leetcode.com/problems/find-original-array-from-doubled-array/
 */
public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[0];
        }
        int[] solution = new int[changed.length / 2];

        Map<Integer, Integer> values = new HashMap<>();
        for(int val : changed) {
            values.merge(val, 1, Integer::sum);
        }

        List<Integer> keys = new ArrayList<>(values.keySet());
        Collections.sort(keys);

        int index = 0;
        for (int key : keys) {

            if (values.get(key) > values.getOrDefault(key * 2, 0)) {
                return new int[0];
            } else {
                for(int j = 0; j < values.get(key); j++) {
                    values.put(key * 2, values.get(key * 2) - 1);
                    solution[index] = key;
                    index++;
                }

            }
        }
        return solution;
    }
}
