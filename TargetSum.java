package DSA.DynamicProgramming;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {

        int[] ar = {1,2,3,1};
        System.out.println(targetSum2(ar.length , 3 , ar));
    }
    public static int targetSum(int n, int target, int[] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int s = sum + target;

        // System.out.println(s);

        if(s%2!=0){
            return 0;
        }

        target = s/2;

       // System.out.println("target : " + target);


        int[][] dp = new int[n][target+1];
        for(int i = 0;i<n;i++){
            dp[i][0] = 0;
        }

//        if(arr[0]<=target){
//            dp[0][arr[0]] = 1;
//        }


        if(arr[0]==0){
            dp[0][0] = 2;
        }else {
            dp[0][0] = 1;
        }

        if(arr[0] != 0 && arr[0]<=target){
            dp[0][arr[0]]=1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < dp[0].length ; j++) {
                int pick = 0;
                if(j>=arr[i]){
                    pick = dp[i-1][j-arr[i]];
                }
                int notPick = dp[i-1][j];

                dp[i][j] = pick + notPick;
            }
        }


//        for (int[] ar : dp){
//            System.out.println(Arrays.toString(ar));
//        }

        return dp[n-1][target];

    }

    public static int targetSum2(int n, int target, int[] arr) {
        return countPartitionsTB(n,target , arr);
    }

    public static int countPartitionsTB(int n, int d, int[] arr) {

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if ((sum + d) % 2 != 0) {
            return 0;
        }

        int target = (sum + d) / 2;

        int[][] dp =  new int[n][target+1];

        if(arr[0]==0){
            dp[0][0] = 2;
        }else {
            dp[0][0] = 1;
        }

        if(arr[0] != 0 && arr[0]<=target){
            dp[0][arr[0]]=1;
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int pick = 0;
                if(j>=arr[i]){
                    pick = dp[i-1][j-arr[i]];
                }

                int notPick = dp[i-1][j];

                dp[i][j] = pick + notPick;
            }

        }

        return dp[n-1][target];
    }
}
