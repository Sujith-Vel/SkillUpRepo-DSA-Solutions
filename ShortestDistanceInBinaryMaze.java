package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestDistanceInBinaryMaze {
    public static void main(String[] args) {

//        int grid[][] = {{1, 1, 1, 1},
//            {1, 1, 0, 1},
//            {1, 1, 1, 1},
//            {1, 1, 0, 0},
//            {1, 0, 0, 1}};

        int grid[][] = {{1 ,1, 1, 0, 0}};
        int[] source = {0, 2};
        int[] destination = {0,0};

        System.out.println(shortestPath(grid,source,destination));

    }
   public static int shortestPath(int[][] grid, int[] source, int[] destination) {

        int[][] distance = new int[grid.length][grid[0].length];
        for (int[] ar : distance){
            Arrays.fill(ar,Integer.MAX_VALUE);
        }

        PriorityQueue<DistNode> queue = new PriorityQueue<>((a,b)-> a.distance- b.distance);
        queue.offer(new DistNode(source[0],source[1],0));
        distance[source[0]][source[1]] = 0;

        while (!queue.isEmpty()){
            DistNode d = queue.poll();

            if(d.row == destination[0] && d.col == destination[1]) {
                return distance[d.row][d.col];
            }

            if(d.row+1< grid.length && grid[d.row+1][d.col] != 0 && distance[d.row+1][d.col]>distance[d.row][d.col]+1){
                queue.offer(new DistNode(d.row+1,d.col,distance[d.row][d.col]+1));
                distance[d.row+1][d.col] = distance[d.row][d.col]+1;
            }

            if(d.col+1< grid[0].length && grid[d.row][d.col+1] != 0 && distance[d.row][d.col+1]>distance[d.row][d.col]+1){
                queue.offer(new DistNode(d.row,d.col+1,distance[d.row][d.col]+1));
                distance[d.row][d.col+1] = distance[d.row][d.col]+1;
            }

            if(d.row-1>=0 && grid[d.row-1][d.col]!=0 && distance[d.row-1][d.col]>distance[d.row][d.col]+1){
                queue.offer(new DistNode(d.row-1,d.col,distance[d.row][d.col]+1));
                distance[d.row-1][d.col] = distance[d.row][d.col]+1;
            }

            if(d.col-1>=0 && grid[d.row][d.col-1] !=0 && distance[d.row][d.col-1]>distance[d.row][d.col]+1){
                queue.offer(new DistNode(d.row,d.col-1,distance[d.row][d.col]+1));
                distance[d.row][d.col-1] = distance[d.row][d.col]+1;
            }
        }

       // return distance[destination[0]][destination[1]];
       return distance[destination[0]][destination[1]]==Integer.MAX_VALUE?-1:distance[destination[0]][destination[1]];
   }

    public static class DistNode{

        int row;
        int col;
        int distance;

        public DistNode( int row,int col ,int distance){
            this.row = row;
            this.col=col;
            this.distance = distance;
        }

    }
}
