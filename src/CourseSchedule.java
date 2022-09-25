/**
 * @author Davis Jeffrey
 */

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi]
 * indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Intuition: Topological sort.
 * Link: https://leetcode.com/problems/course-schedule/
 */

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; //Indicates that link i -> j is present
        int[] indegree = new int[numCourses]; //Number of edges pointing to that node


        for (int i = 0; i < prerequisites.length; i++) {
            int finalCourse = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            //If this is the first time we're seeing the link preCourse -> finalCourse
            if (matrix[preCourse][finalCourse] == 0) {
                //Add an indegree for finalCourse
                indegree[finalCourse]++;
            }
            //Mark this as seen
            matrix[preCourse][finalCourse] = 1;
        }

        int count = 0;
        //Topological sort
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            //If there's a node that has no indegrees, it has no dependencies. Take that node.
            if (indegree[i] == 0) {
                queue.offer(i);
            };
        }

        //Check queue level by level
        while (!queue.isEmpty()) {
            count++; //Each node in the queue == node with no indegrees
            int currentCourse = queue.poll();
            for (int i = 0; i < numCourses; i++) {
                //If there exists a link between the currentNode and other nodes, remove it
                if (matrix[currentCourse][i] != 0) {
                    indegree[i] = indegree[i] - 1;
                    //If on removing this link that node has no indegrees, add to queue
                    if (indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}

/*
 * boolean[][] hasEdge = new boolean[numCourses][numCourses];
        int[] indegrees = new int[numCourses];

        //Go through all prerequisites, add edges and indegrees as needed
        for(int i = 0; i < prerequisites.length; i++) {
            int preCourse = prerequisites[i][1];
            int mainCourse = prerequisites[i][0];

            if (!hasEdge[preCourse][mainCourse]) {
                indegrees[mainCourse]++;
            }
            hasEdge[preCourse][mainCourse] = true;
        }

        //Put all nodes with no indegrees in the queue
        Queue<Integer> freeNodes = new ArrayDeque<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                freeNodes.offer(i);
            }
        }

        int count = 0;
        while (!freeNodes.isEmpty()) {
            count++;
            int currentCourse = freeNodes.poll();
            for (int i = 0; i < numCourses; i++) {
                if (hasEdge[currentCourse][i]) {
                    hasEdge[currentCourse][i] = false;
                    indegrees[i]--;
                    if (indegrees[i] == 0) {
                        freeNodes.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
 */
