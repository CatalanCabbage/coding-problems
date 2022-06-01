/**
 * Problem:
 * We are given an array asteroids of integers representing asteroids in a row.
 * For each asteroid, the absolute value represents its size,
 * and the sign represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions.
 * If two asteroids meet, the smaller one will explode. If both are the same size, both will explode.
 * Two asteroids moving in the same direction will never meet.
 *
 * Link: https://leetcode.com/problems/asteroid-collision/
 *
 * Eg: Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 */


class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length < 2) {
            return asteroids;
        }

        //Keep track of this to build the result array in the end
        int explodedAsteroids = 0;

        //Start from the right, keep moving left, destroying asteroids as needed (set to 0)
        for (int i = 1; i < asteroids.length; i++) {
            //Check left
            for (int j = i - 1; j >= 0 && (asteroids[i] < 0 && asteroids[j] >= 0); j--) {
                //Skip destroyed asteroids
                if (asteroids[j] != 0) {
                    if (asteroids[i] + asteroids[j] == 0) {
                        //i is equal to left
                        asteroids[i] = 0;
                        asteroids[j] = 0;
                        explodedAsteroids += 2;
                    } else if (asteroids[i] + asteroids[j] < 0) {
                        //i is larger
                        asteroids[j] = 0;
                        explodedAsteroids++;
                    } else {
                        //i is smaller
                        asteroids[i] = 0;
                        explodedAsteroids++;
                    }
                }
            }
        }

        int[] result = new int[asteroids.length - explodedAsteroids];
        for (int i = 0, j = 0; i < asteroids.length && j < asteroids.length; i++) {
            if (asteroids[i] != 0) {
                result[j] = asteroids[i];
                j++;
            }
        }
        return result;
    }
}
