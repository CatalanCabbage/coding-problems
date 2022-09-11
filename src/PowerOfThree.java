/**
 * Problem:
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 *
 * Link: https://leetcode.com/problems/power-of-three/
 */


class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        double nDouble = n;
        while (nDouble >= 3.0) {
            if (nDouble == 3.0) {
                return true;
            }
            nDouble = nDouble / 3.0;
        }
        return false;
    }
}
