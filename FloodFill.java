package DSA.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {

        int [][] image = {{1,1,1},{1,1,0},{1,0,1}};

        int[][] ans = floodFill(image ,1 , 1 , 2);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }


    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc]==color){
            return image;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr , sc});
        int init = image[sr][sc];
        image[sr][sc] = color;

        while (!queue.isEmpty()){

            int[] ar = queue.poll();

            if(ar[0]+1<image.length && image[ar[0]+1][ar[1]]==init){
                queue.add(new int[]{ar[0]+1,ar[1]});
                image[ar[0]+1][ar[1]]=color;
            }

            if(ar[0]-1>=0 && image[ar[0]-1][ar[1]]==init){
                queue.add(new int[]{ar[0]-1,ar[1]});
                image[ar[0]-1][ar[1]]=color;
            }

            if(ar[1]+1<image[0].length && image[ar[0]][ar[1]+1]==init){
                queue.add(new int[]{ar[0],ar[1]+1});
                image[ar[0]][ar[1]+1]=color;
            }

            if(ar[1]-1>=0 && image[ar[0]][ar[1]-1]==init){
                queue.add(new int[]{ar[0],ar[1]-1});
                image[ar[0]][ar[1]-1]=color;
            }

        }

        return image;
    }
}
