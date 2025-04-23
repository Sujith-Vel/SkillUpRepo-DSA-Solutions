package DSA.DynamicProgramming;

public class WaysToMakeCoinChange {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(countWaysToMakeChangeSOO(arr , 4));
    }
    public static long countWaysToMakeChange(int denominations[], int value){
        return helper(denominations , denominations.length-1 , value);
    }

    private static long helper(int[] arr, int n, int t) {

        if(t==0){
            return 1;
        }
        long pick = 0;
        long notPick = 0;

        if(t>=arr[n]){
            pick = helper(arr , n , t-arr[n]);
        }
        if(n>0){
            notPick = helper(arr , n-1 , t);
        }

        return pick + notPick;
    }

    public static long countWaysToMakeChangeMM(int denominations[], int value){
        long[][] dp = new long[denominations.length][value+1];
        return helperMM(denominations , denominations.length-1 , value , dp);
    }

    private static long helperMM(int[] arr, int n, int t, long[][] dp) {

        if(t==0){
            return 1;
        }
        long pick = 0;
        long notPick = 0;

        if(dp[n][t]!=0){
            return dp[n][t];
        }

        if(t>=arr[n]){
            pick = helperMM(arr , n , t-arr[n], dp);
        }
        if(n>0){
            notPick = helperMM(arr , n-1 , t, dp);
        }

        dp[n][t] = pick + notPick;

        return pick + notPick;
    }

    public static long countWaysToMakeChangeTB(int denominations[], int value){
        long[][] dp = new long[denominations.length][value+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                long pick = 0;
                long notPick = 0;
                if(j>=denominations[i]){
                    pick = dp[i][j-denominations[i]];
                }

                if(i>0){
                    notPick = dp[i-1][j];
                }

                dp[i][j] = pick + notPick;

            }
        }

        return dp[denominations.length-1][value];
    }

    public static long countWaysToMakeChangeSO(int denominations[], int value){
        long[] dp = new long[value+1];
        dp[0] = 1;

        long[] temp = new long[value+1];
        temp[0] = 1;

        for (int i = 0; i < denominations.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                long pick = 0;
                long notPick = 0;
                if(j>=denominations[i]){
                    pick = temp[j-denominations[i]];
                }
                if(i>0){
                    notPick = dp[j];
                }
                temp[j] = pick + notPick;
            }
            long[] t = dp;
            dp = temp;
            temp = t;
        }

        return dp[value];
    }


    public static long countWaysToMakeChangeSOO(int denominations[], int value){
        long[] dp = new long[value+1];
        dp[0] = 1;

        for (int i = 0; i < denominations.length; i++) {
            for (int j = denominations[i]; j < dp.length; j++) {
                dp[j] +=  dp[j-denominations[i]];
            }
        }

        return dp[value];
    }



}
