package DSA.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinSubsetSumDifference {
    public static void main(String[] args) {

        int[] arr = {8,6,5};
        System.out.println(minSubsetSumDifferenceSP(arr , arr.length));
    }

    public static int minSubsetSumDifference(int []arr, int n) {
        int sum = 0;
        for (int e : arr){
            sum += e;
        }

        int min = Integer.MAX_VALUE;
        for (int i = sum/2; i <=sum ; i++) {
            if(i<min && helperFun(n-1 , i , arr)){
                min = i;
            }
        }

        return Math.abs(min - Math.abs(sum - min));
    }

    private static boolean helperFun(int n , int target ,int[] arr) {

        if(arr[n]==target){
            return true;
        }

        if(n==0){
           return arr[0]==target;
        }

        boolean take = false;

        if (target>=arr[n]){
            take = helperFun(n-1,target-arr[n] , arr);
        }

        boolean notTake = helperFun(n-1,target , arr);

        return take || notTake;

    }

    // Memoization

    public static int minSubsetSumDifferenceMM(int []arr, int n) {
        int sum = 0;
        for (int e : arr){
            sum += e;
        }



        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n][(sum/2)+1];

           helperFunMM(n-1 , sum/2 , arr , dp);
           for (int[] ar : dp){
               System.out.println(Arrays.toString(ar));
           }

        return Math.abs(min - Math.abs(sum - min));
    }

    private static boolean helperFunMM(int n , int target , int[] arr, int[][] dp) {

        if(arr[n]==target){
            return true;
        }

        if(n==0){
            return arr[0]==target;
        }

        if(dp[n][target]!=0){
            // 1  -> true
            // -1 -> false
            return dp[n][target]==1;
        }

        boolean take = false;

        if (target>=arr[n]){
            take = helperFunMM(n-1,target-arr[n] , arr, dp);
        }

        boolean notTake = helperFunMM(n-1,target , arr, dp);

        dp[n][target] = take || notTake?1:-1;

        return take || notTake;

    }

    // Tabulation
    public static int minSubsetSumDifferenceTB(int []arr, int n) {
        int sum = 0;
        for (int e : arr){
            sum += e;
        }
        boolean[][] dp = new boolean[n][(sum/2)+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        if(arr[0]<dp[0].length){
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <dp[0].length; j++) {
                dp[i][j] = false;
               if(dp[i-1][j]){
                   dp[i][j] = true;
               }else if(j-arr[i] >= 0 && dp[i-1][j-arr[i]]){
                   dp[i][j] = true;
               }
            }
        }

        int min = -1;

        for(int i =0;i<dp[0].length;i++){
            if(dp[dp.length-1][i]){
                if(min<i){
                    min = i;
                }
            }
        }
        return Math.abs(min - Math.abs(sum-min));
    }


    // Space Optimization
    public static int minSubsetSumDifferenceSP(int[]arr , int n) {
        int sum = 0;
        for (int e : arr){
            sum += e;
        }
        boolean[] dp = new boolean[(sum/2)+1];
        boolean[] temp = new boolean[(sum/2)+1];
        dp[0] = true;
        temp[0] = true;

        if(arr[0]<dp.length){
            dp[arr[0]] = true;
            temp[arr[0]] = true;
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < dp.length; j++) {

                temp[j] = false;
                if (dp[j]) {
                    temp[j] = true;
                } else if (j - arr[i] >= 0 && dp[j - arr[i]]) {
                    temp[j] = true;
                }

            }
            boolean[] t = dp;
            dp = temp;
            temp = t;
        }

        int min = -1;

        for(int i =0;i<dp.length;i++){
            if(dp[i]){
                if(min<i){
                    min = i;
                }
            }
        }
        return Math.abs(min - Math.abs(sum-min));
    }

}
