/**
 * Problem: You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version,
 * all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 *
 * Link: https://leetcode.com/problems/first-bad-version/
 */


class FirstBadVersion {
    private boolean isBadVersion(int i) {
        //Dummy impl
        return i < 5;
    }
    public int firstBadVersion(int n) {
        int lo = 0;
        int hi = n;
        //Cases:
        //n = 5, bad = 1
        //n = 5, bad = 5
        //n = 6, bad = 3
        while(lo <= hi) {
            int mid = hi - ((hi - lo) / 2);
            if (isBadVersion(mid) && !isBadVersion(mid - 1)) {
                return mid;
            }
            if (!isBadVersion(mid) && isBadVersion(hi)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return 0;
    }
}
