package DSA.DynamicProgramming;

import java.util.Arrays;

public class MinSumPath {
    public static void main(String[] args) {

//    int[][] grid = {{5,9,6},
//                    {11,5,2}};

//        int[][] grid = {{8,1,6},
//                        {4,4,16},
//                        {2,7,20},
//                        {20,7,20}};

        int[][] grid = {
                {1, 100, 1},
                {1, 1, 100},
                {100, 1, 1}
        };


//        int[][] grid = { {1,5},
//                         {2,7} };

        System.out.println(minSumPathMemo(grid));
        System.out.println(minSumPathSpaceOpt(grid));
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE);//2147483647

    }

    public static int minSumPath(int[][] grid) {
        return helperFun(grid.length-1, grid[0].length-1,grid);
    }

    private static int helperFun(int i, int j, int[][] grid) {


        if(i==0 && j==0){
            return grid[0][0];
        }

        if(i<0 || j<0){
            return Integer.MAX_VALUE;
        }
            int left = Math.abs(grid[i][j] + helperFun(i-1, j, grid));

            int right = Math.abs(grid[i][j] + helperFun(i,j-1,grid));

           return Math.min(left , right);
    }

    // Using DP

    public static int minSumPath2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return helperFun2(grid.length-1, grid[0].length-1,grid,dp);
    }

    private static int helperFun2(int i, int j, int[][] grid , int[][] dp) {
        if(i==0 && j==0){
            return grid[0][0];
        }

        if(i<0 || j<0){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int left = grid[i][j] + helperFun2(i-1, j, grid , dp);

        int right = grid[i][j] + helperFun2(i,j-1,grid , dp);

        dp[i][j] = Math.min(left , right);

        return  dp[i][j];
    }

    // Tabulation

    public static int minSumPathMemo(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i==0 && j==0){
                   dp[i][j] = grid[0][0];
                }else {
                    int left = Integer.MAX_VALUE;
                    int right = Integer.MAX_VALUE;
                    if(i>0){
                        left = grid[i][j] + dp[i-1][j];
                    }
                    if(j>0){
                         right = grid[i][j] + dp[i][j-1];
                    }

                    dp[i][j] = Math.min(left , right);
                }
            }
            for (int[] ar : dp){
                System.out.println(Arrays.toString(ar));
            }
            System.out.println("-----------------------------------");
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    // space optimization

    public static int minSumPathSpaceOpt(int[][] grid) {
        int[] dp = new int[grid[0].length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < grid.length; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                   dp[j] = grid[i][j] + Math.min(dp[j-1],dp[j]);
                }
            }
        return dp[dp.length-1];
    }


}
