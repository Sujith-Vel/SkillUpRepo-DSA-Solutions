package DSA.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {

        int[][] edges = {{0,1}, {1,2}, {2,3}};
        System.out.println(topoSort(4,edges));

    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {

        // Creating Adjacent list with given edges
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        //----------Adjacent list created------------


        boolean[] visited= new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                dfs(i,visited,adjList,stack);
            }
        }

     ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }

        return res;
    }

    private static void dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adjList, Stack<Integer> stack) {

    visited[i] = true;

    for(int e : adjList.get(i)){
        if(!visited[e]){
            dfs(e,visited,adjList,stack);
        }
    }
        stack.add(i);
    }
}
