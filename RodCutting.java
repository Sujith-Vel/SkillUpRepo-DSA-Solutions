package DSA.DynamicProgramming;

public class RodCutting {
    public static void main(String[] args) {

        int[] arr = {2,5,7,8,10};
        System.out.println(cutRodSOO(arr , 5));

    }

    public static int cutRodRC(int price[], int n) {
        // Write your code here.
        return helper(n-1 , n , price);
    }

    private static int helper(int n, int t, int[] price) {
        if(t==0){
            return 0;
        }
        int p = 0 , np = 0;

        if(t>=(n+1)){
            p = price[n] + helper(n,t-(n+1) ,price);
        }

        if(n>0){
            np = helper(n-1,t,price);
        }
        return Math.max(p,np);
    }


    public static int cutRod(int price[], int n) {
        // Write your code here.

        int[][] dp = new int[n][n+1];

//        for (int i = 0; i < n; i++) {
//            dp[i][0] = 0;
//        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j <dp[0].length; j++) {
                int p = 0 , np = 0;
              if(j>=i+1){
                  p = price[i] + dp[i][j-(i+1)];
              }
                if(i>0){
                    np = dp[i-1][j];
                }

                dp[i][j] = Math.max(p , np);
            }
        }

        return dp[n-1][n];
    }


    public static int cutRodSO(int price[], int n) {
        // Write your code here.

        int[] dp = new int[n+1];
        dp[0] = 0;

        int[] temp = new int[n+1];


        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j <=n; j++) {
                int p = 0 , np = 0;
                if(j>=i+1){
                    p = price[i] + temp[j-(i+1)];
                }
                if(i>0){
                    np = dp[j];
                }
                temp[j] = Math.max(p , np);
            }
            int[] t = dp;
            dp = temp;
            temp = t;
        }

        return dp[n];
    }

    public static int cutRodSOO(int price[], int n) {
        // Write your code here.

        int[] dp = new int[n+1];
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = i+1; j <=n; j++) {
                dp[j] = Math.max(dp[j],price[i] + dp[j-(i+1)]);
            }
        }

        return dp[n];
    }


}
