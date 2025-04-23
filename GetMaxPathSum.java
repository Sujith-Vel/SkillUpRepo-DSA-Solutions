package DSA.DynamicProgramming;

import java.util.Arrays;

public class GetMaxPathSum {
    public static void main(String[] args) {

        int[][] matrix = {{1,2,10,4},{100,3,2,1},{1,1,20,2},{1,2,2,1}};
        for (int[] ar : matrix){
            System.out.println(Arrays.toString(ar));
        }
        System.out.println("-----------------------------");

        System.out.println(getMaxPathSumTabulationSpaceOpt(matrix));

    }
    public static int getMaxPathSum(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int val = helper(matrix , matrix.length-1 , i);
            if(max<val){
                max = val;
            }
        }
        return max;
    }

    private static int helper(int[][] matrix, int i, int j) {
        if(i==0 && j==0){
            return matrix[0][0];
        }
        if(i==0 && j>=0 && j<matrix[0].length){
            return matrix[i][j];
        }
        if(i<0 || j<0 || j>matrix[0].length-1){
            return Integer.MIN_VALUE;
        }
        int up = matrix[i][j] + helper(matrix , i-1  , j);

        int diaL =  matrix[i][j] + helper(matrix , i-1  , j-1);

        int  diaR =  matrix[i][j] + helper(matrix , i-1  , j+1);

        return Math.max(up , Math.max(diaL , diaR));
    }

    // using dp

    public static int getMaxPathSumDp(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int val = helperDp(matrix , matrix.length-1 , i , dp);
            if(max<val){
                max = val;
            }
        }
        return max;
    }

    private static int helperDp(int[][] matrix, int i, int j, int[][] dp) {
        if(i==0 && j==0){
            return matrix[0][0];
        }
        if(i==0 && j>=0 && j<matrix[0].length){
            return matrix[i][j];
        }
        if(i<0 || j<0 || j>matrix[0].length-1){
            return Integer.MIN_VALUE;
        }

        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int up = matrix[i][j] + helperDp(matrix , i-1  , j, dp);

        int diaL =  matrix[i][j] + helperDp(matrix , i-1  , j-1, dp);

        int  diaR =  matrix[i][j] + helperDp(matrix , i-1  , j+1, dp);

        dp[i][j] = Math.max(up , Math.max(diaL , diaR));

        return dp[i][j];
    }

    // using tabulation
    // Space Comp => O(n*m)
    // time Comp => O(n*m))
    public static int getMaxPathSumTabulation(int[][] matrix) {

        if(matrix.length==1 && matrix[0].length==1){
            return matrix[0][0];
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        int maxValForOneRow = Integer.MIN_VALUE;;
        for (int i = 0; i < dp[0].length; i++) {
            if(maxValForOneRow<matrix[0][i]){
                maxValForOneRow = matrix[0][i];
            }
            dp[0][i] = matrix[0][i];
        }

        if(matrix.length==1 ){
            return maxValForOneRow;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                long diaL =  Integer.MIN_VALUE;
                long  diaR =  Integer.MIN_VALUE;

                long up = matrix[i][j] + dp[i - 1][j];
                if(j>0){
                    diaL =  matrix[i][j] + dp[i-1][j-1];
                }
                if(j<matrix[0].length-1){
                     diaR =  matrix[i][j] + dp[i-1][j+1];
                 }

                dp[i][j] = (int)Math.max(up , Math.max(diaL , diaR));

                if(i==matrix.length-1 && max<dp[i][j]){
                    max = dp[i][j];
                }
            }
            for (int[] ar : dp){
                System.out.println(Arrays.toString(ar));
            }
            System.out.println("-----------------------------");
        }
        return max;
    }

    // Space Optimize
    // Space Comp => O(2m)
    // Time Comp => O(n*m)

    public static int getMaxPathSumTabulationSpaceOpt(int[][] matrix) {

        if(matrix.length==1 && matrix[0].length==1){
            return matrix[0][0];
        }

        int[] dp = new int[matrix[0].length];
        int max = Integer.MIN_VALUE;
        int maxValForOneRow = Integer.MIN_VALUE;;
        for (int i = 0; i < dp.length; i++) {
            if(maxValForOneRow<matrix[0][i]){
                maxValForOneRow = matrix[0][i];
            }
            dp[i] = matrix[0][i];
        }

        if(matrix.length==1 ){
            return maxValForOneRow;
        }

        int[] temp = new int [dp.length];

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                long diaL =  Integer.MIN_VALUE;
                long  diaR =  Integer.MIN_VALUE;
                long up = matrix[i][j] + dp[j];
                if(j>0){
                    diaL =  matrix[i][j] + dp[j-1];
                }
                if(j<matrix[0].length-1){
                    diaR =  matrix[i][j] + dp[j+1];
                }

                temp[j] = (int)Math.max(up , Math.max(diaL , diaR));

                if(i==matrix.length-1 && max<temp[j]){
                    max = temp[j];
                }
            }

            int[] swap = dp;
            dp = temp;
            temp = swap;

        }
        return max;
    }

}
