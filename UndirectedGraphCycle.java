package DSA.Graph;

import java.util.ArrayList;

public class UndirectedGraphCycle {
    public static void main(String[] args) {

        int[][] edges =  {{1,2}, {2,3}};
        System.out.println(isCycle2(3,edges));

    }

    public static boolean isCycle2(int V, int[][] edges) {

        // Adjacent list is not give in question , so we're creating our own
        ArrayList<ArrayList<Integer>> adjAr = new ArrayList<>();
        for (int i = 0; i < V+1; i++) {
            adjAr.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjAr.get(edges[i][0]).add(edges[i][1]);
            adjAr.get(edges[i][1]).add(edges[i][0]);
        }
        // ----------Adjacent list created--------


        // Visited Array Created to detect the cycle
        boolean[] visited = new boolean[V+1];

        // here we are looping from 0 to adjAr size , why because ,
        // what if there are many one unconnected graphs

        for (int i = 0; i < adjAr.size(); i++) {

            // if any point we get the true from the dfs() , we can stop the loop
            // and return true , means we find the cycle.

            // in dfs() , we are passing -1 as parent node , its like dummy value.
            if(!visited[i] && dfs2(i,-1,visited,adjAr)){
                return true;
            }
        }
        return false;
    }

    private static boolean dfs2(int curNode, int parNode, boolean[] visited, ArrayList<ArrayList<Integer>> adjAr) {

        // The first thing , we need to mark true in the visited[]
        visited[curNode] = true;

      for(int e : adjAr.get(curNode)){
          if(e!=parNode && visited[e]){
              return true;
          }else if (e!=parNode){
              if(dfs2(e,curNode,visited,adjAr)){ // CurrentNode to now parentNode
                  return true;
              }
          }
      }
        return false;
    }
}
