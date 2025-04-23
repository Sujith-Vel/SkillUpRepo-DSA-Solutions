package DSA.DynamicProgramming;

import java.util.Arrays;

public class SubsetSumToK {
    public static void main(String[] args) {
         int[] ar = {3,1,5,2,8,1};
      //  System.out.println(subsetSumToKDpTabulation(4,1,ar));
        System.out.println(subsetSumToKTab(ar.length,10,ar));

    }

    public static boolean subsetSumToK(int n, int k, int arr[]) {
        return helperFun(n-1 , k , arr);
    }

    private static boolean helperFun(int i, int k, int[] arr) {
        if(k==0){
            return true;
        }
        if(i==0){
            return arr[0]==k;
        }
        boolean take = false;
        if(arr[i]<=k) {
            take = helperFun(i-1 , k-arr[i] , arr);
        }

        boolean notTake = helperFun(i-1,k,arr);

        return take || notTake;

    }

    // using dp memoization
    public static boolean subsetSumToKDp(int n, int k, int arr[]) {
        int[][] dp = new int[n][k+1];
        boolean ans = helperFunDp(n-1 , k , arr , dp);
        for (int[] e : dp){
            System.out.println(Arrays.toString(e));
        }
        return ans;
    }

    private static boolean helperFunDp(int i, int k, int[] arr, int[][] dp) {
        if(k==0){
            return true;
        }
        if(i==0){
            return k==arr[0];
        }
        if(dp[i][k]!=0){
            // 1 -> true
            // 2 -> false
            return dp[i][k] == 1;
        }
        boolean take = false;
        if(arr[i]<=k) {
            take = helperFunDp(i-1 , k-arr[i] , arr, dp);
        }

        boolean notTake = helperFunDp(i-1,k,arr, dp);

        if((take || notTake)){
            dp[i][k] = 1;
        }else {
            dp[i][k] = 2;
        }
        return take || notTake;
    }

    // Tabulation

    public static boolean subsetSumToKDpTabulation(int n, int k, int arr[]) {
        boolean[][] dp = new boolean[n][k+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if(arr[0]<k){
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <=k; j++) {
                boolean take = false;
                if(j-arr[i]>=0) {
                    take = dp[i-1][j-arr[i]];
                }

                boolean notTake = dp[i-1][j];

                dp[i][j] = take || notTake;
            }
        }
        return dp[n-1][k];
    }

    //------------------------------------------------


        public static boolean subsetSumToKTab(int n, int k, int arr[]) {
            boolean[][] dp = new boolean[n][k + 1];
            System.out.println(dp[0][3]);

            // Base Case: A subset with sum 0 always exists (empty subset)
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }

            // Base Case: First row (only one element to consider)
            if (arr[0] <= k) {
                dp[0][arr[0]] = true;
            }

            // Filling DP Table
            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= k; j++) {
                    boolean notTake = dp[i - 1][j]; // Not including arr[i]
                    boolean take = false;
                    if (arr[i] <= j) {
                        take = dp[i - 1][j - arr[i]]; // Including arr[i]
                    }
                    dp[i][j] = take || notTake; // If either is true, subset exists
                }
            }

            for (boolean[] e : dp){
                System.out.println(Arrays.toString(e));
            }

            return dp[n - 1][k]; // Answer is in the last cell
        }
}
