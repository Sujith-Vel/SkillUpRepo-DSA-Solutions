package DSA.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {

        int[][] grid = {{0}};
        System.out.println(orangesRotting(grid));

    }
    public static int orangesRotting(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }else if(grid[i][j]==0){
                    visited[i][j] = true;
                }
            }
        }

        int count = -1;

        while (!queue.isEmpty()){
            int len = queue.size();
            count++;
            for (int i = 0; i < len; i++) {
                int[] ar = queue.poll();

                if(ar[0]+1<grid.length && !visited[ar[0]+1][ar[1]]){
                    queue.add(new int[]{ar[0]+1,ar[1]});
                    visited[ar[0]+1][ar[1]]=true;
                }

                if(ar[0]-1>=0 && !visited[ar[0]-1][ar[1]]){
                    queue.add(new int[]{ar[0]-1,ar[1]});
                    visited[ar[0]-1][ar[1]]=true;
                }

                if(ar[1]+1<grid[0].length && !visited[ar[0]][ar[1]+1]){
                    queue.add(new int[]{ar[0],ar[1]+1});
                    visited[ar[0]][ar[1]+1]=true;
                }

                if(ar[1]-1>=0 && !visited[ar[0]][ar[1]-1]){
                    queue.add(new int[]{ar[0],ar[1]-1});
                    visited[ar[0]][ar[1]-1]=true;
                }

            }
        }

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
               if(!visited[i][j]){
                   return -1;
               }
            }
        }

        return count==-1?0:count;
    }
}
