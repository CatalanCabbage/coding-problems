/**
 * Problem:
 * There are several cards arranged in a row, and each card has an associated number of points.
 * The points are given in the integer array cardPoints.
 *
 * In one step, you can take one card from the beginning or from the end of the row.
 * You have to take exactly k cards.
 * Your score is the sum of the points of the cards you have taken.
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 *
 * Link: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 *
 * Times: 1 Rating: 0
 */

class MaximumPointsYouCanObtainFromCards {
    //Say len = 10, k = 5.
    //Take 5 from left, 0 from right; 4 from left, 1 from right; 3 from left, 2 from right etc.
    //So essentially pop the last element on the left and add an element on the right in each iteration
    //https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/discuss/598095/Java-Prefix-Sum-O(n)-with-clear-explanation-and-learning-notes
    public int maxScore(int[] cardPoints, int k) {
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += cardPoints[i];
        }
        int maxSum = currentSum;

        int right = cardPoints.length - 1;
        for (int left = k - 1; left >= 0; left--) {
            //Take from the right
            currentSum += cardPoints[right];
            right--;
            //Subtract last from the left
            currentSum -= cardPoints[left];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;

    }


    ////Most points = (sum of all) - (min subarray of size length-k)
    //https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/discuss/2197791/Reframing-The-Question-or-JAVA-Explained
    public int maxScoreSlidingWindow(int[] cardPoints, int k) {
        int totalSum = 0;
        //Get sum of all elements, to subtract from in the end
        for (int i = 0; i < cardPoints.length; i++) {
            totalSum += cardPoints[i];
        }
        if (k >= cardPoints.length) {
            return totalSum;
        }

        int left = 0;
        int right = cardPoints.length - k;
        int currentMin = 0;
        //Initialize window with (length - k) elements. Left inclusive, right exclusive
        for (int i = 0; i < right; i++) {
            currentMin += cardPoints[i];
        }
        int minSum = currentMin;

        //To work out: Should we take [right] or [right + 1]?
        while (right < cardPoints.length) {
            //Keep expanding the window by 1
            currentMin -= cardPoints[left];
            currentMin += cardPoints[right];
            left++;
            right++;
            minSum = Math.min(minSum, currentMin);
        }
        System.out.println(minSum);
        return totalSum - minSum;
    }
}
