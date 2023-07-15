/*
                         Course Schedule

     -->  There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

     -->   For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
          Return true if you can finish all courses. Otherwise, return false.
*/

public class Main {
    public static void main(String[] args) {
       Solution solution = new Solution();
       int numCourses = 2;
       int[][] prerequisites = {{1,0}, {0, 1}};
       boolean courseCompletionStatus = solution.canFinish(numCourses, prerequisites);

        System.out.println(courseCompletionStatus);
    }
}