import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Problem:
 * Given an array of points where points[i] = [xi, yi]
 * represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. T
 * he answer is guaranteed to be unique (except for the order that it is in).
 *
 * Link: https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * Eg: Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 */


class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int[][] closest = new int[k][];
        //Find distance of all points from origin and insert in a PQ
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare((int)(Math.pow(a[0], 2) + Math.pow(a[1], 2)), (int)(Math.pow(b[0], 2) + Math.pow(b[1], 2)))
        );
        for (int i = 0; i < points.length; i++) {
            minHeap.offer(points[i]);
        }

        //Pop k elements
        for (int i = 0; i < k; i++) {
            closest[i] = minHeap.poll();
        }
        return closest;
    }
}