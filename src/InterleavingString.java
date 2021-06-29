/**
 * Problem:
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * <p>
 * Link: https://leetcode.com/problems/interleaving-string
 */

//Note: First do a recursive solution, then save and short-circuit visited combinations -> DP
class InterleavingString {
    int[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        memo = new int[s1.length() + 1][s2.length() + 1];
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        char[] s3Arr = s3.toCharArray();
        if ((s1Arr.length + s2Arr.length) != s3Arr.length) {
            return false;
        }
        return hasSolution(s1Arr, s2Arr, s3Arr, 0, 0, 0);
    }

    private boolean hasSolution(char[] arr1, char[] arr2, char[] arr3, int p1, int p2, int p3) {
        boolean result = false;

        //If arr3 has reached its end, it means that all chars leading up to this had matched.
        if (p3 >= arr3.length) {
            return true;
        }

        //Both arr1 and arr2 have reached the end.
        if ((p1 >= arr1.length) && (p2 >= arr2.length)) {
            return false;
        }

        //If we've seen this before, return the value stored
        if (memo[p1][p2] != 0) {
            return memo[p1][p2] == 1;
        }

        //Try using the first array
        if ((p1 < (arr1.length)) && (arr1[p1] == arr3[p3])) {
            result = hasSolution(arr1, arr2, arr3, p1 + 1, p2, p3 + 1);
            memo[p1][p2] = result ? 1 : 2;
        }

        if (result) {
            return result;
        }

        //If it didn't give the result, try using the second array
        if (p2 < (arr2.length) && arr2[p2] == arr3[p3]) {
            result = hasSolution(arr1, arr2, arr3, p1, p2 + 1, p3 + 1);
            memo[p1][p2] = result ? 1 : 2;
        }

        return result;
    }
}
