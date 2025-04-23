package DSA.DynamicProgramming;

import java.util.Arrays;

public class CountSubsetsWithSumK {
    public static void main(String[] args) {
    //  int[] arr = {0,1,3};
        int[] arr = {1,1,1,1};

        System.out.println(findWaysSP(arr , 3));
    }


    public static int findWays(int[] num ,int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];

        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }

        if(tar+1>num[0]){
            dp[0][num[0]]=1;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<tar+1;j++){
                int pick = 0;
                if(j-num[i]>=0){
                    pick = dp[i-1][j-num[i]];
                }
                int notPick = dp[i-1][j];
                dp[i][j] = pick + notPick ;
            }
        }

        return dp[n-1][tar];
    }

    public static int findWaysSP(int[] num ,int tar) {

        int n = num.length;
        int[] dp = new int[tar+1];
        int[] temp = new int[tar+1];

        dp[0] = 1;
        temp[0] = 1;

        if(tar+1>num[0]){
            dp[num[0]]=1;
            temp[num[0]]=1;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<tar+1;j++){
                int pick = 0;
                if(j>=num[i]){
                    pick = dp[j-num[i]];
                }
                int notPick = dp[j];
                temp[j] = pick + notPick;
            }
            int[] t = dp;
            dp = temp;
            temp = t;
        }

        System.out.println(Arrays.toString(dp));

        return dp[tar];
    }
}
