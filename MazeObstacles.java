package DSA.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeObstacles {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        matrix.add(new ArrayList<>(Arrays.asList(0, 0, -1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(-1, 0, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(0, -1, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

     //   System.out.println(mazeObstaclesUsingDpIteration(3,6,matrix));
        System.out.println(mazeObstaclesSpaceOptimization(3,6,matrix));
    }

    // Brute Force using Recursion
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {

       return helperFun(0,0,mat);
    }

    private static int helperFun(int i, int j, ArrayList<ArrayList<Integer>> mat) {
        if(i==mat.size()-1  && j==mat.getFirst().size()-1){
            return 1;
        }
        if(mat.get(i).get(j)==-1){
            return 0;
        }

        int ans = 0;
        if(i<mat.size()-1){
            ans += helperFun(i+1 , j , mat);
        }
        if(j<mat.getFirst().size()-1){
            ans += helperFun(i , j+1 , mat);
        }
        return ans;
    }

    // Using Recursion without helper function
    static int mazeObstacles2(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        if(n<=1  && m<=1){
            return 1;
        }
        if(mat.get(n-1).get(m-1)==-1){
            return 0;
        }

        int ans = 0;

        if(n>1){
            ans += mazeObstacles2(n-1 , m , mat);
        }
        if(m>1){
            ans += mazeObstacles2(n , m-1 , mat);
        }
        return ans;
    }

    // Using Dp

    static int mazeObstaclesUsingDp(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] dp = new int[n][m];
        return dpHelper(n-1,m-1,mat,dp);
    }

    static int dpHelper(int n, int m, ArrayList<ArrayList<Integer>> mat , int[][] dp) {
        if(n==0  && m==0){
            return 1;
        }

        if(dp[n][m]!=0){
            return dp[n][m];
        }

        if(mat.get(n).get(m)==-1){
            return 0;
        }


        int ans = 0;

        if(n>0){
            ans += dpHelper(n-1 , m , mat , dp);
        }
        if(m>0){
            ans += dpHelper(n , m-1 , mat , dp);
        }
        dp[n][m] = ans;

        return ans;
    }

// Using Dp iteration - Tabulation

    static int mazeObstaclesUsingDpIteration(int n, int m, ArrayList<ArrayList<Integer>> mat) {

        int[][] dp = new int[n][m];

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if(i==0 && j ==0 ){
                    continue;
                }

                if(mat.get(i).get(j)==-1){
                    dp[i][j] = 0;
                    continue;
                }

                int ans = 0;

                if(i>0){
                    ans += dp[i-1][j];
                }
                if(j>0){
                    ans += dp[i][j-1];
                }
                dp[i][j] = ans;
            }

            for (int[] ar : dp){
                System.out.println(Arrays.toString(ar));
            }
            System.out.println("---------------------");
        }



      return dp[n-1][m-1];
    }

    // Using Dp iteration -  Space Optimization

    static int mazeObstaclesSpaceOptimization(int n, int m, ArrayList<ArrayList<Integer>> mat) {

     int[] dp = new int[mat.get(0).size()];
     dp[0] = 1;
        for (int i = 0; i < mat.size(); i++) {
            if(mat.get(i).get(0)==-1){
                dp[0] = 0;
            }
            for (int j = 1; j < mat.get(0).size(); j++) {
                if(mat.get(i).get(j)==-1){
                    dp[j] = 0;
                }else {
                    dp[j] += dp[j-1];
                }
            }
        }

        return dp[mat.get(0).size()-1];
    }
}
