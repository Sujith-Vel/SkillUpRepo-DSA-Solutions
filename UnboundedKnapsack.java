package DSA.DynamicProgramming;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] profit = {5, 11, 13};
        int[] weight = {2, 4, 6};

        System.out.println(unboundedKnapsackSOO(weight.length , 10 , profit,weight));
    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.

        return helper(n-1 , w , profit , weight);
    }

    private static int helper(int n, int w, int[] profit, int[] weight) {
        if(w==0){
            return 0;
        }

        int pick = 0;
        int notPick = 0;

        if(w>=weight[n]){
            pick = profit[n] + helper(n,w-weight[n],profit, weight);
        }

        if(n>0){
            notPick = helper(n-1,w,profit, weight);
        }

        return Math.max(pick , notPick);
    }

    public static int unboundedKnapsackTB(int n, int w, int[] profit, int[] weight) {

        int[][] dp = new int[n][w+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <=w; j++) {
                int pick = 0;
                int notPick = 0;

                if(j>=weight[i]){
                    pick = profit[i] + dp[i][j-weight[i]];
                }

                if(i>0){
                    notPick = dp[i-1][j];
                }

                dp[i][j] = Math.max(pick , notPick);
            }
        }

        return dp[n-1][w];
    }

    public static int unboundedKnapsackSO(int n, int w, int[] profit, int[] weight) {

        int[] dp = new int[w+1];
        dp[0] = 0;

        int[] temp = new int[w+1];
        temp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <=w; j++) {
                int pick = 0;
                int notPick = 0;

                if(j>=weight[i]){
                    pick = profit[i] + temp[j-weight[i]];
                }

                if(i>0){
                    notPick = dp[j];
                }

                temp[j] = Math.max(pick , notPick);
            }

            int[] t = dp;
            dp = temp;
            temp = t;
        }

        return dp[w];
    }

    public static int unboundedKnapsackSOO(int n, int w, int[] profit, int[] weight) {

        int[] dp = new int[w+1];
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = weight[i]; j <=w; j++) {
                dp[j] = Math.max(dp[j],profit[i] + dp[j-weight[i]]);
            }
        }
        return dp[w];
    }

}
