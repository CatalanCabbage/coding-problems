/**
 * @author Davis Jeffrey
 */
package patterns.dp;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 *such that each number is the sum of the two preceding ones, starting from 0 and 1.
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 *
 * Given n, calculate F(n).
 */

public class FibonacciNumber {
    public int fib(int n) {
        //Bottom-up
        int[] db1 = new int[n + 1];
        db1[0] = 0;
        db1[1] = 1;
        for (int i = 2; i <= n; i++) {
            //We can improve this further by storing only 2 numbers
            db1[i] = db1[i - 1] + db1[i - 2];
        }
        return db1[n];

        // int[] db = new int[n + 1];
        // return topDown(n, db);
    }
    private int topDown(int n, int[] db) {
        if (n < 2) {
            return n;
        }
        if (db[n] == 0) {
            db[n] = topDown(n - 1, db) + topDown(n - 2, db);
        }
        return db[n];
    }
}
