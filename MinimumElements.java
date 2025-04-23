package DSA.DynamicProgramming;

import java.util.Arrays;

public class MinimumElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(minimumElementsSO(arr , 7));
       // System.out.println(Integer.MAX_VALUE);
        //2147483647
    }
    public static int minimumElements(int num[], int x) {
         long val = helper(num , num.length-1 , x);
         if(val<=0){
             return -1;
         }
         return (int)val;
    }

    private static int helper(int[] num, int n, int target) {

        if(n==0){
            if(target%num[n]==0){
                return  target/num[n];
            }
            return Integer.MAX_VALUE;
        }

        if(target==0){
            return 0;
        }
        long pick = Integer.MAX_VALUE;
        if(target>=num[n]){
            pick = 1 + helper(num , n , target-num[n]);
        }
        long notPick = helper(num , n-1 , target);

        return (int) Math.min(pick , notPick);
    }




    public static int minimumElementsTB(int num[], int x) {

        long[][] dp = new long[num.length][x+1];

        for (int i = 0; i < num.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <=x; i++) {
            if(i%num[0]==0){
                dp[0][i] = i/num[0];
            }else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                long notPick = dp[i-1][j];
                long pick = Integer.MAX_VALUE;
                if(j>=num[i]){
                    pick = 1 + dp[i][j-num[i]];
                }

                dp[i][j] = (int)Math.min(pick , notPick);
            }
        }

        for (long[] ar : dp){
            System.out.println(Arrays.toString(ar));
        }
        if(dp[dp.length-1][x]>Integer.MAX_VALUE){
            return -1;
        }

        return (int)dp[dp.length-1][x];
    }

    public static int minimumElementsSO(int num[], int x) {

        long[] dp = new long[x+1];
        long[] temp = new long[x+1];
        dp[0] = 0;
        temp[0] = 0;

        for (int i = 0; i <=x; i++) {
            if(i%num[0]==0){
                dp[i] = i/num[0];
                temp[i] = i/num[0];
            }else {
                dp[i] = Integer.MAX_VALUE;
                temp[i] = Integer.MAX_VALUE;
            }
        }


        for (int i = 1; i < num.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                long notPick = dp[j];
                long pick = Integer.MAX_VALUE;
                if(j>=num[i]){
                    pick = 1 + temp[j-num[i]];
                }
                temp[j] = (int)Math.min(pick , notPick);
            }
            long[] t = dp;
            dp = temp;
            temp = t;
        }
        if(dp[x]>=Integer.MAX_VALUE){
            return -1;
        }
        return (int)dp[x];
    }

}
