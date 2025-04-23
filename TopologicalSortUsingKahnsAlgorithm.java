package DSA.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingKahnsAlgorithm {
    public static void main(String[] args) {

        int[][] edges = {{0,1}, {1,2}, {2,3}};
        System.out.println(topoSort(4,edges));
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {

        int[] indegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        // Creating Adjacent list with given edges
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            indegree[edges[i][1]]++;
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        //----------Adjacent list created------------

        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);

            for (int e : adjList.get(node)){
                indegree[e]--;
                if(indegree[e]==0){
                    queue.add(e);
                }
            }
        }

        return res;
    }
}
