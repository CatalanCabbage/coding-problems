import java.util.Arrays;

/**
 * Problem:
 * You are given a series of video clips from a sporting event that lasted time seconds.
 * These video clips can be overlapping with each other and have varying lengths.
 *
 * Each video clip is described by an array clips where clips[i] = [starti, endi]
 * indicates that the ith clip started at starti and ended at endi.
 *
 * We can cut these clips into segments freely.
 *     For example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
 *
 * Return the minimum number of clips needed so that we can cut the clips into segments
 * that cover the entire sporting event [0, time]. If the task is impossible, return -1.
 *
 * Link: https://leetcode.com/problems/video-stitching/
 */


class VideoStitching {
    public int videoStitching(int[][] clips, int time) {
        if (clips.length == 0) {
            return -1;
        }
        //Sort values by start time
        Arrays.sort(clips, (a, b) -> Integer.compare(a[0], b[0]));

        int result = 0;
        int index = 0;
        int currentTime = 0;
        if (clips[0][0] != 0) {
            return -1;
        }

        //Do this till we get to the time we need
        while (currentTime < time) {
            int currentMax = 0;

            //Iterate through all elements that start before our end time
            //find the clip with the max end. Our aim is to get as far as possible in time.
            while (index < clips.length && clips[index][0] <= currentTime) {
                currentMax = Math.max(currentMax, clips[index][1]);
                index++;
            }

            //If max is <= our current end time, it means it can't be extended any more.
            //ie., there is no clip that joins this end time to the next clip.
            if (currentMax <= currentTime) {
                return -1;
            }
            //Take that interval's end, increment result
            currentTime = currentMax;
            result++;
        }
        return result;
    }
}
