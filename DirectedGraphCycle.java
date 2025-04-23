package DSA.Graph;

import java.util.ArrayList;

public class DirectedGraphCycle {
    public static void main(String[] args) {

    }
    public static boolean isCyclic(int V, int[][] edges) {

    //https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=chatgpt.com

        // Creating adjacent list with given edges
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
        }

        // adjacent list created

        // creating 2 boolean arrays ,
        // 1. visited is for track the visited nodes
        // 2. pathVisited is also for track the visited nodes , but it will change to false once after returning
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                if(dfs(i,visited,pathVisited,adjList)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(int i, boolean[] visited, boolean[] pathVisited, ArrayList<ArrayList<Integer>> adjList) {

    visited[i] = true;
    pathVisited[i] = true;

    for (int e : adjList.get(i)){
        if(pathVisited[e]){
            return true;
        }else if(!visited[e]){
            if(dfs(e,visited,pathVisited,adjList)){
                return true;
            }
        }
    }

    pathVisited[i] = false;

    return false;
    }
}
