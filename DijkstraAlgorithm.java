package DSA.Graph;

import java.util.*;

public class DijkstraAlgorithm {
    public static void main(String[] args) {

        int[][] edges = {{0, 1, 4}, {0, 2, 8}, {1, 4, 6}, {2, 3, 2}, {3, 4, 10}};
        System.out.println(Arrays.toString(dijkstraUsingSet(5, edges, 0)));

    }
    public static int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<DistNode>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(new DistNode(edges[i][2],edges[i][1]));
            adjList.get(edges[i][1]).add(new DistNode(edges[i][2],edges[i][0]));
        }

        PriorityQueue<DistNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.distanceFromSrc));
        int[] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        queue.offer(new DistNode(0,src));
        distance[src]=0;

        while (!queue.isEmpty()){
            DistNode d = queue.poll();
            for (DistNode e : adjList.get(d.node)){
                if(distance[e.node]>(d.distanceFromSrc+e.distanceFromSrc)){
                    distance[e.node] = d.distanceFromSrc+e.distanceFromSrc;
                    queue.offer(new DistNode(d.distanceFromSrc+e.distanceFromSrc,e.node));
                }
            }
        }

        return distance;
    }

    public static class DistNode{
        int distanceFromSrc;
        int node;

        public DistNode(int distanceFromSrc ,int node){
            this.distanceFromSrc = distanceFromSrc;
            this.node = node;
        }

        @Override
        public String toString() {
            return "Distance : " + this.distanceFromSrc + " | " + "Node : " + this.node ;
        }
    }

    public static int[] dijkstraUsingSet(int V, int[][] edges, int src) {
        ArrayList<ArrayList<DistNode>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(new DistNode(edges[i][2],edges[i][1]));
            adjList.get(edges[i][1]).add(new DistNode(edges[i][2],edges[i][0]));
        }

        //TreeSet<DistNode> set = new TreeSet<>(Comparator.comparingInt(a -> a.distanceFromSrc)); // if both having same distance this compare will not work!
        TreeSet<DistNode> set = new TreeSet<>((a, b) -> {
            if (a.distanceFromSrc != b.distanceFromSrc)
                return a.distanceFromSrc - b.distanceFromSrc;
            return a.node - b.node; // Important: Break ties using node ID
        });

        int[] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        set.add(new DistNode(0,src));
        distance[src]=0;

        while (!set.isEmpty()){
            DistNode d = set.pollFirst();
            for (DistNode e : adjList.get(d.node)){
                if(distance[e.node]>(d.distanceFromSrc+e.distanceFromSrc)){

                    set.remove(new DistNode(distance[e.node],e.node));

                    distance[e.node] = d.distanceFromSrc+e.distanceFromSrc;
                    set.add(new DistNode(d.distanceFromSrc+e.distanceFromSrc,e.node));

                }
            }
        }

        return distance;
    }

}
