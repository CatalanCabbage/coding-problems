import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * You are given an array of people, people, which are the attributes of some people in a queue
 * (not necessarily in order).
 * Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people
 * in front who have a height greater than or equal to hi.
 *
 * Reconstruct and return the queue that is represented by the input array people.
 * The returned queue should be formatted as an array queue, where queue[j] = [hj, kj]
 * is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).
 *
 * Link: https://leetcode.com/problems/queue-reconstruction-by-height/
 *
 * Times: 1
 * Rating: 2
 */

//https://leetcode.com/problems/queue-reconstruction-by-height/discuss/167308/Python-solution
class QueueReconstructionByHeight {
    public static int[][] reconstructQueue(int[][] people) {
        //Sort by decreasing height, ascending people in front
        Arrays.sort(people,
            (a, b) -> b[0] == a[0] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));

        /* How does this work?
         * Case 1: list = [[7,0],[7,1]], newElement = [6,1]
         *      We can add it at index 1, since smaller heights don't matter to [7,1]
         *      list = [[7,0],[6,1],[7,1]]
         * Case 2: list = [[7,0],[6,1],[7,1]], newElement = [6,2]
         *      We can add it at index 2, since it'll always be inserted after [6,1] (sorting result)
         *      and smaller heights don't matter to anything on the right, like [7,1]
         *      list = [[7,0],[6,1],[6,2],[7,1]]
        */
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        int[][] res = reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
        for(int i = 0; i < res.length; i++) {
            System.out.print("[" + res[i][0] + "," + res[i][1] + "], ");
        }
        System.out.println();
        System.out.println("Expected [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]");
    }
}
