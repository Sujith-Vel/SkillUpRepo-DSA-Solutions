package DSA.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // https://leetcode.com/problems/course-schedule/
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
            inDegree[prerequisites[i][1]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        if(queue.isEmpty()){
            return false;
        }

        while (!queue.isEmpty()){
            int node = queue.poll();
                count++;
            for (int e : adjList.get(node)){
                inDegree[e]--;
                if(inDegree[e]==0){
                    queue.offer(e);
                }
            }

        }

        return count==numCourses;
    }

}
