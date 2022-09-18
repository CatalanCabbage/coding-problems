/**
 * @author Davis Jeffrey
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem:
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 *
 * Link: https://leetcode.com/problems/combinations/
 */
public class Combinations {
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        //for (int i = 1; i <= n; i++) {
        // System.out.println("-------------- For: " + i);
        getCombination(n, k, 1, new ArrayList<>());
        //}
        return solution;
    }
    //for each nth char, time is
    //n for last char,
    private void getCombination(int n, int k, int i, List<Integer> list) {
        if (list.size() == k) {
            solution.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j <= n; j++) {
            //System.out.println("Adding " + j);
            //Add i
            list.add(j);
            //Pass list and call it again to add this
            getCombination(n, k, j + 1, list);
            //Remove i
            //System.out.println("Removing " + j);
            list.remove((Integer)j);
        }
    }
}
