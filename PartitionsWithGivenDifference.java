package DSA.DynamicProgramming;

public class PartitionsWithGivenDifference {
    public static void main(String[] args) {

     //   int[] arr = {1,3,1,3,6,2,5,0};

        int[] arr = {1,3,1,3,6,2,5,0};

     //   System.out.println(countPartitions(arr.length, 7 , arr));
        System.out.println(countPartitionsChat(arr.length, 7 , arr));
        System.out.println(countPartitionsNew(arr.length, 7 , arr));
        System.out.println(countPartitionsTB(arr.length, 7 , arr));
        System.out.println(countPartitionsSO(arr.length, 7 , arr));


    }
    public static int countPartitions(int n, int d, int[] arr) {

        int noOfZeros = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                noOfZeros++;
            }
            sum += arr[i];
        }

     //   System.out.println(noOfZeros);

        int s1 = sum + d;
        System.out.println("sum + d : " + s1);
        if(s1%2!=0){
            return 0;
        }

        s1 = s1/2;

      //  System.out.println("s1 : " + s1);

        int[][] dp = new int[n][s1+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
//
//        if(arr[0]<=s1){
//            dp[0][arr[0]] = 1;
//        }

        for (int i = 1; i < n; i++) {
//            if(arr[i]==0){
//                continue;
//            }
            for (int j = 1; j <= s1; j++) {
                if (arr[i] == 0) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                int pick = 0;

                if(j>=arr[i]){
                    pick = dp[i-1][j-arr[i]];
                }


                int notPick = dp[i-1][j];

                dp[i][j] = pick+notPick;
            }
        }

      // System.out.println(dp[n-1][s1]);

        return  (int) Math.pow(2,noOfZeros) * dp[n-1][s1];
    }


    public static int countPartitionsChat(int n, int d, int[] arr) {
        int sum = 0, noOfZeros = 0;

        // Compute sum and count zeros
        for (int num : arr) {
            sum += num;
            if (num == 0) noOfZeros++;
        }

        // If (sum + d) is odd, partitioning is impossible
        if ((sum + d) % 2 != 0) return 0;
        int target = (sum + d) / 2;

        // DP array
        int[] dp = new int[target + 1];
        dp[0] = 1;

        // Populate DP array
        for (int num : arr) {
            if (num == 0) continue; // Zero doesn't contribute to sum directly
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        System.out.println("dp[target] : " + dp[target]);
        System.out.println( "Pow : " + (int) Math.pow(2, noOfZeros));

        // Multiply by 2^noOfZeros to account for placing zeros in either subset
        return dp[target] * (int) Math.pow(2, noOfZeros);
    }


    public static int countPartitionsNew(int n, int d, int[] arr) {

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if ((sum + d) % 2 != 0) {
            return 0;
        }

        int target = (sum + d) / 2;

        return helperFun(n-1 , target , arr);
    }

    private static int helperFun(int n, int k, int[] arr) {

        if(n==0){
            if(k==0 && arr[0]==0){
                return 2;
            }
            if(k==arr[0] || k==0){
                return 1;
            }
            return 0;
        }

        int pick = 0;
        if(k>=arr[n]){
            pick = helperFun(n-1 ,k-arr[n] , arr);
        }

        int notPick = helperFun(n-1 ,k , arr);

        return pick + notPick;
    }


    public static int countPartitionsMM(int n, int d, int[] arr) {

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if ((sum + d) % 2 != 0) {
            return 0;
        }

        int target = (sum + d) / 2;

        int[][] dp =  new int[n][target+1];

        return helperFunMM(n-1 , target , arr , dp);
    }

    private static int helperFunMM(int n, int k, int[] arr, int[][] dp) {

        if(n==0){
            if(k==0 && arr[0]==0){
                return 2;
            }
            if(k==arr[0] || k==0){
                return 1;
            }
            return 0;
        }

        if(dp[n][k]!=0){
            return dp[n][k];
        }

        int pick = 0;
        if(k>=arr[n]){
            pick = helperFunMM(n-1 ,k-arr[n] , arr, dp);
        }

        int notPick = helperFunMM(n-1 ,k , arr, dp);

        dp[n][k] = pick + notPick;

        return pick + notPick;
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

    public static int countPartitionsSO(int n, int d, int[] arr) {

        int MOD = 1_000_000_007;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if ((sum + d) % 2 != 0) {
            return 0;
        }

        int target = (sum + d) / 2;

        int[] dp =  new int[target+1];
        int[] temp =  new int[target+1];

        if(arr[0]==0){
            dp[0] = 2;
            temp[0] = 2;
        }else {
            dp[0] = 1;
            temp[0] = 1;
        }

        if(arr[0] != 0 && arr[0]<=target){
            dp[arr[0]]=1;
            temp[arr[0]]=1;
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int pick = 0;
                if(j>=arr[i]){
                    pick = dp[j-arr[i]] % MOD;
                }

                int notPick = dp[j] % MOD;

                temp[j] = (pick + notPick) % MOD;
            }

            int[] t = dp;
            dp = temp;
            temp = t;

        }

        return dp[target];

    }


}
