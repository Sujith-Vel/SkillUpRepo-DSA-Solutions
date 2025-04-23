package DSA.DynamicProgramming;

import java.util.Arrays;

public class Knapsack {
    public static void main(String[] args) {
        int[] weight = {1,2,4,5};
        int[] value  = {5,4,8,6};
        System.out.println(knapsackSO(weight , value , weight.length , 5));
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return helper(weight , value , n-1 , maxWeight );
    }

    private static int helper(int[] weight, int[] value, int n, int maxWeight) {

        if(n==0){
            if(weight[0]<=maxWeight){
                return value[0];
            }
            return 0;
        }

        if(maxWeight==0){
            return 0;
        }
        int pick = 0;
        if(maxWeight>=weight[n]){
            pick = value[n] + helper(weight,value , n-1 , maxWeight-weight[n]);
        }

        int notPick =  helper(weight,value , n-1 , maxWeight);

        return Math.max(pick , notPick);
    }

    static int knapsackDP(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];

        int val = helperDP(weight , value , n-1 , maxWeight , dp);

        for (int[] ar : dp){
            System.out.println(Arrays.toString(ar));
        }

        return val;
    }

    private static int helperDP(int[] weight, int[] value, int n, int maxWeight, int[][] dp) {

        if(n==0){
            if(weight[0]<=maxWeight){
                return value[0];
            }
            return 0;
        }

        if(maxWeight==0){
            return 0;
        }

        if(dp[n][maxWeight]!=0){
            return dp[n][maxWeight];
        }
        int pick = 0;
        if(maxWeight>=weight[n]){
            pick = value[n] + helperDP(weight,value , n-1 , maxWeight-weight[n], dp);
        }

        int notPick =  helperDP(weight,value , n-1 , maxWeight, dp);

        dp[n][maxWeight] = Math.max(pick , notPick);

        return  dp[n][maxWeight];
    }


    static int knapsackTB(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];

        for (int i = weight[0]; i <=maxWeight; i++) {
            dp[0][i] = value[0];
        }

        for (int i = 0; i<n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <=maxWeight ; j++) {
                int pick = 0;

                if(j>=weight[i]){
                    pick = value[i] + dp[i-1][j-weight[i]];
                }
                int notPick = dp[i-1][j];
                dp[i][j] = Math.max(pick , notPick);
            }
        }

        return dp[n-1][maxWeight];
    }


    static int knapsackSO(int[] weight, int[] value, int n, int maxWeight) {
        int[]dp = new int[maxWeight+1];
        int[]temp = new int[maxWeight+1];

        for (int i = weight[0]; i <=maxWeight; i++) {
            dp[i] = value[0];
            temp[i] = value[0];
        }

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <=maxWeight ; j++) {
                int pick = 0;

                if(j>=weight[i]){
                    pick = value[i] + dp[j-weight[i]];
                }
                int notPick = dp[j];
                temp[j] = Math.max(pick , notPick);
            }
            int[] t = dp;
            dp = temp ;
            temp = t;
        }

        return dp[maxWeight];
    }



}
