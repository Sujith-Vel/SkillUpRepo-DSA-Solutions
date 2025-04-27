package DSA.Graph;

import java.util.*;

public class ShortestPathInWeightedUndirectedGraph {
    public static void main(String[] args) {

        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};

        System.out.println(shortestPathUsingPQ(5,6,edges));

    }

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.

        ArrayList<ArrayList<DistNode>> adjList = new ArrayList<>();

        for (int i = 0; i <=n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(new DistNode(edges[i][2],edges[i][1]));
            adjList.get(edges[i][1]).add(new DistNode(edges[i][2],edges[i][0]));
        }

        TreeSet<DistNode> set = new TreeSet<>(
           (o1,  o2) -> {
                if(o1.distance!=o2.distance){
                    return o1.distance-o2.distance;
                }
                return o1.node- o2.node;
            }
        );

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int[] tracker = new int[n+1];

        set.add(new DistNode(0,1));
        distance[1]=0;

        while (!set.isEmpty()){
            DistNode d = set.pollFirst();
            for (DistNode neighbour : adjList.get(d.node)){

                if(distance[neighbour.node]>d.distance+neighbour.distance){

                    set.remove(new DistNode(distance[neighbour.node],neighbour.node));
                    distance[neighbour.node]=d.distance+neighbour.distance;
                    set.add(new DistNode(distance[neighbour.node],neighbour.node));

                    tracker[neighbour.node] = d.node;
                }
            }
        }


        ArrayList<Integer> list = new ArrayList<>();

//        if (tracker[n]==0){
//            list.add(-1);
//            return list;
//        }
//
//       while (tracker[n]!=0){
//           list.addFirst(n);
//           n=tracker[n];
//       }
//       list.addFirst(1);

        if (tracker[n]==0){
            list.add(-1);
            return list;
        }

        while (tracker[n]!=0){
            list.add(0,n);
            n=tracker[n];
        }
        list.add(0,1);


        return list;
    }

    public static class DistNode{

        int distance;
        int node;

        public DistNode(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }


    public static List<Integer> shortestPathUsingPQ(int n, int m, int edges[][]) {
        //  Code Here.

        ArrayList<ArrayList<DistNode>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(new DistNode(edges[i][2], edges[i][1]));
            adjList.get(edges[i][1]).add(new DistNode(edges[i][2], edges[i][0]));
        }

        PriorityQueue<DistNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        // PriorityQueue<DistNode> queue = new PriorityQueue<>((o1, o2)->  o1.distance - o2.distance );

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int[] tracker = new int[n + 1];

        queue.add(new DistNode(0, 1));
        distance[1] = 0;

        while (!queue.isEmpty()) {
            DistNode d = queue.poll();
            for (DistNode neighbour : adjList.get(d.node)) {

                if (distance[neighbour.node] > d.distance + neighbour.distance) {

                    distance[neighbour.node] = d.distance + neighbour.distance;
                    queue.add(new DistNode(distance[neighbour.node],neighbour.node));

                    tracker[neighbour.node] = d.node;
                }
            }
        }


        ArrayList<Integer> list = new ArrayList<>();

        if (tracker[n]==0){
            list.add(-1);
            return list;
        }

        while (tracker[n]!=0){
            list.add(0,n);
            n=tracker[n];
        }
        list.add(0,1);


        return list;
    }
}
