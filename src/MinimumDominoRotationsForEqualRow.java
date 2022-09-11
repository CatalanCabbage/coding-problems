/**
 * Problem:
 * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino.
 * (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 * We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
 *
 * Return the minimum number of rotations so that all the values in tops are the same,
 * or all the values in bottoms are the same.
 *
 * If it cannot be done, return -1.
 *
 * Link: https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */


class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] top, int[] bottom) {
        //Count occurrence of each number in top and bottom.
        //Edge case: Both top and bottom are the same number.
        int[] topCount = new int[7];
        int[] bottomCount = new int[7];
        int sameNums = 0;
        for (int i = 0; i < top.length; i++) {
            topCount[top[i]] += 1;
            bottomCount[bottom[i]] += 1;
            if (top[i] == bottom[i]) {
                sameNums++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < topCount.length; i++) {
            if (topCount[i] + bottomCount[i] - sameNums == top.length) {
                min = Math.min(min, Math.min(topCount[i], bottomCount[i]) - sameNums);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    //O(n) solution
    public int minDominoRotationsBF(int[] top, int[] bottom) {
        if (top.length != bottom.length) {
            return -1;
        }
        //Iterate top, rotate all mismatches
        //Iterate bottom, rotate all mismatches
        //Pick the smallest
        int minTop = Math.min(getRotations(top, bottom, top[0]), getRotations(top, bottom, bottom[0]));
        int minBottom = Math.min(getRotations(bottom, top, top[0]), getRotations(bottom, top, bottom[0]));

        int min = Math.min(minTop, minBottom);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int getRotations(int[] top, int[] bottom, int targetNum) {
        int rotations = 0;

        for (int i = 0; i < top.length; i++) {
            if (top[i] != targetNum) {
                //Check if bottom has what we want and rotate it
                if (bottom[i] == targetNum) {
                    rotations++;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return rotations;
    }
}
