/**
 * Problem:
 * Given n orders, each order consist in pickup and delivery services.
 * Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * Link: https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
 */


class CountAllValidPickupAndDeliveryOptions {
    //Solution 3 - permutations
    //https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/solution/
    public int countOrders(int n) {
        long ans = 1;
        int mod = 1_000_000_007;
        for (int i = 1; i <= n; i++) {
            //Place pickups
            ans = ans * i;

            //Place deliveries
            ans = ans * (2 * i - 1);

            ans = ans % mod;
        }
        return (int)ans;
    }
}
