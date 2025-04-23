package DSA.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j]=='1'){
                    count++;
                    bfs(grid , visited , i , j);
                }
            }
        }

        return count;
    }

    private static void bfs(char[][] grid, boolean[][] visited , int i , int j) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;

      while (!queue.isEmpty()){
          int[] ind = queue.poll();
          i = ind[0];
          j = ind[1];
          if(i-1>=0 && grid[i-1][j]=='1' && !visited[i-1][j] ){
              queue.add(new int[]{i-1,j});
              visited[i-1][j] = true;
          }

          if(i+1<grid.length && grid[i+1][j]=='1' && !visited[i+1][j] ){
              queue.add(new int[]{i+1,j});
              visited[i+1][j] = true;
          }

          if(j-1>=0 && grid[i][j-1]=='1' && !visited[i][j-1] ){
              queue.add(new int[]{i,j-1});
              visited[i][j-1] = true;
          }

          if(j+1<grid[0].length && grid[i][j+1]=='1' && !visited[i][j+1] ){
              queue.add(new int[]{i,j+1});
              visited[i][j+1] = true;
          }

      }

    }
}
