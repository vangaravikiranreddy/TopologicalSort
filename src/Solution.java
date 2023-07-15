import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[] indegree;

    public void buildGraph(int[][] prerequisites, ArrayList<ArrayList<Integer>> graph, int n) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pr : prerequisites) {
            graph.get(pr[1]).add(pr[0]);
            indegree[pr[0]]++;
        }
    }

    public void addFinishedCourse(Queue<Integer> pq) {
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        indegree = new int[numCourses];

        buildGraph(prerequisites, graph, numCourses);

        Queue<Integer> pq = new LinkedList<>();

        addFinishedCourse(pq);

        int countFinishedCourses = 0; // counts total finished courses

        while (!pq.isEmpty()) {
            int curCourse = pq.remove();

            countFinishedCourses++;

            for (int adjNode : graph.get(curCourse)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    pq.add(adjNode);
                }
            }
        }

        return (countFinishedCourses == numCourses);
    }
}
