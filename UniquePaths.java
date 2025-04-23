package DSA.DynamicProgramming;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePathsUsingDp(3,3));
        System.out.println(uniquePathsUsingDpIteration(3,3));
    }

   static int count = 0;

    public static int uniquePaths(int m, int n) {
        counter(m,n,0,0);
        return count;
    }
    public static void counter(int m, int n , int i , int j) {
        if(i==m-1 && j==n-1){
            count++;
            return ;
        }

        if(i<m-1){
            counter(m,n,i+1,j);
        }
        if(j<n-1){
            counter(m,n,i,j+1);
        }
    }

    // count in the method

    public static int uniquePaths2(int m, int n) {

        return counter2(m,n,0,0 );
    }
    public static int counter2(int m, int n , int i , int j) {
        if(i==m-1 && j==n-1){
            return 1;
        }

        int cnt = 0;
        if(i<m-1){
            cnt  += counter2(m,n,i+1,j);
        }
        if(j<n-1){
            cnt += counter2(m,n,i,j+1);
        }
        return cnt;
    }

    // without extra variable
    // count in the method

    public static int uniquePaths3(int m, int n) {

        if(m==1 && n==1){
            return 1;
        }

        int cnt = 0;
        if(m>1){
            cnt  += uniquePaths3(m-1,n);
        }
        if(n>1){
            cnt += uniquePaths3(m,n-1);
        }
        return cnt;
    }

    // Using Dp with 2D array
    public static int uniquePathsUsingDp(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        return helperFun(m,n,dp);
    }


    private static int helperFun(int m, int n, int[][] dp) {
        if(m==1 && n==1){
            return 1;
        }

        if(dp[m][n]!=0){
            return dp[m][n];
        }

        int cnt = 0;

        if(m>1){
            cnt  += helperFun(m-1,n , dp);
        }
        if(n>1){
            cnt += helperFun(m,n-1 , dp);
        }
        dp[m][n] = cnt;

        for (int[] ar : dp){
            System.out.println(Arrays.toString(ar));
        }
        System.out.println("---------------------");

        return cnt;
    }

    // Using Dp with 2D array and Iteration
    public static int uniquePathsUsingDpIterationPattern(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp , 1);
        for (int i = 0; i < m-1; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }

        return dp[n-1];
    }

    // Using Dp with 2D array Tabulation
    public static int uniquePathsUsingDpIteration(int m, int n) {
        int[][] dp = new int[m][n];
         dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 && j==0){
                    continue;
                }
                int left = 0;
                int right = 0;
                if(i>0){
                    left += dp[i-1][j];
                }
                if(j>0){
                    right += dp[i][j-1];
                }
                dp[i][j] = left + right;
            }
        }
        return dp[m-1][n-1];
    }
}
