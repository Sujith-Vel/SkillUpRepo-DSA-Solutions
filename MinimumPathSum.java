package DSA.DynamicProgramming;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
   //int[][] triangle =  {{1}, {2,3}, {4,5,6}};
//        int[][] triangle =   {{2},
//            {3,4},
//            {6,5,7},
//            {4,1,8,3}};

        int[][] triangle ={{5},
        {-1,3},
        {22,1,-9}};
        System.out.println(minimumPathSum(triangle ,triangle.length));
        System.out.println(minimumPathSumDPTabulation(triangle , triangle.length));
        for(int[] ar : triangle){
            System.out.println(Arrays.toString(ar));
        }
        System.out.println("__________________");
        System.out.println("__________________");

       System.out.println(minimumPathSumDPTabulationSpaceOptimization2(triangle , triangle.length));
//        int max = Integer.MAX_VALUE;
//        int min = Integer.MIN_VALUE;
//        System.out.println(max+4);
//        System.out.println(min);
    }

    public static int minimumPathSum(int[][] triangle, int n) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int min = (int)helperFun(triangle , n-1 , i , i+1 );
            if(res > min){
                res = min;
            }
        }
        return res;
    }

    private static long helperFun(int[][] triangle, int i, int j , int n) {
        if(i==0 && j==0){
            return triangle[0][0];
        }
        if(j<0 || i<j ){
            return Integer.MAX_VALUE;
        }

        long up = triangle[i][j] + helperFun(triangle , i-1 , j , n);
        long dia = triangle[i][j] + helperFun(triangle , i-1 , j-1 , n);

        return Math.min(up , dia);
    }


    // using DP

    public static int minimumPathSumDP(int[][] triangle, int n) {
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            int min = (int)helperFunn(triangle , n-1 , i , dp );
            if(res > min){
                res = min;
            }
        }
        return res;
    }

    private static long helperFunn(int[][] triangle, int i, int j , int[][] dp) {
        if(i==0 && j==0){
            return triangle[0][0];
        }
        if(j<0 || i<j ){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j]!=0){
            return dp[i][j];
        }

        long up = triangle[i][j] + helperFunn(triangle , i-1 , j , dp);
        long dia = triangle[i][j] + helperFunn(triangle , i-1 , j-1 , dp);

        dp[i][j] = (int)Math.min(up , dia);
        return dp[i][j] ;
    }

    // Tabulation

    public static int minimumPathSumDPTabulation(int[][] triangle, int n) {
        if(triangle.length==1){
            return triangle[0][0];
        }
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < triangle[i].length; j++) {
                if(i==0 && j==0){
                    continue;
                }
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                 if(i>j){
                     up = triangle[i][j] + dp[i-1][j];
                 }

                 if(i>0 && j>0){
                     left = triangle[i][j] + dp[i-1][j-1];
                 }

                dp[i][j] = Math.min(up, left);

                 if(i==dp.length-1 && min>dp[i][j]){
                     min = dp[i][j];
                 }
            }
            for(int[] ar : dp){
                System.out.println(Arrays.toString(ar));
            }
            System.out.println("__________________");

        }
        return min;
    }

    // Space optimization

    public static int minimumPathSumDPTabulationSpaceOptimization(int[][] triangle, int n) {
        if(triangle.length==1){
            return triangle[0][0];
        }
        int[] dp = new int[n];

        int min = Integer.MAX_VALUE;
        int temp = triangle[0][0];
        for (int i = 0; i < n; i++) {
            int temp2 = dp[0];
            dp[0] = triangle[i][0] + dp[0];
            if (i==triangle.length-1 ){
                if(min>dp[0]){
                    min = dp[0];
                }
            }
            for (int j = 1; j < triangle[i].length; j++) {
                if(j==triangle[i].length-1){
                    dp[j] = triangle[i][j] + temp;
                }else if (j==1){
                    dp[j] = triangle[i][j] + Math.min(dp[j] , temp2);
                }else{
                    dp[j] = triangle[i][j] + Math.min(dp[j] , dp[j-1]);
                }
              if (i==triangle.length-1 ){
                  if(min>dp[j]){
                      min = dp[j];
                  }
              }
            }
            temp = dp[triangle[i].length-1];
        }
        return min;
    }

// Using Temp array

    public static int minimumPathSumDPTabulationSpaceOptimization2(int[][] triangle, int n) {
        if(triangle.length==1){
            return triangle[0][0];
        }
        int[] dp = new int[n];
        dp[0] = triangle[0][0];
        int[] temp = new int[n];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(i==0 && j==0){
                    temp[0] = dp[0];
                    continue;
                }
                if(j==0){
                    temp[j] = triangle[i][j] + dp[j];
                } else if (j==triangle[i].length-1) {
                    temp[j] =triangle[i][j] +  dp[j-1];
                } else {
                    temp [j] = triangle[i][j] + Math.min(dp[j] , dp[j-1]);
                }
                if(i==dp.length-1 && min>temp[j]){
                    min = temp[j];
                }
            }
            dp = Arrays.copyOfRange(temp,0 , temp.length);
        }
        return min;
    }
}
