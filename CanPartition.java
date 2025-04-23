package DSA.DynamicProgramming;

import java.util.Arrays;

public class CanPartition {
    public static void main(String[] args) {
//        3 1 1 2 2 1
//        6
//        1 1 1 1 1 1
        int[] arr = {3,1,5,2,8,1};
        //   int[] arr = {};
        System.out.println(canPartitionTB(arr, arr.length));
        System.out.println(canPartitionSP(arr, arr.length));


    }

    public static boolean canPartition(int[] arr, int n) {

        int sum = 0;
        for (int e : arr) {
            sum += e;
        }
        System.out.println(sum);
        if (sum % 2 != 0) {
            return false;
        }

        return helper(arr, n - 1, sum / 2);
    }

    private static boolean helper(int[] arr, int n, int sum) {
        if (arr[n] == sum) {
            return true;
        }
        if (n == 0) {
            return arr[0] == sum;
        }

        boolean take = false;
        if (arr[n] <= sum) {
            take = helper(arr, n - 1, sum - arr[n]);
        }

        boolean notTake = helper(arr, n - 1, sum);

        return take || notTake;

    }

    // Memoization

    public static boolean canPartitionMM(int[] arr, int n) {

        int sum = 0;
        for (int e : arr) {
            sum += e;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int[][] dp = new int[n][(sum / 2) + 1];

        return helperMM(arr, n - 1, sum / 2, dp);
    }

    private static boolean helperMM(int[] arr, int n, int sum, int[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return arr[0] == sum;
        }

        if (sum < dp[0].length && dp[n][sum] != 0) {
            return dp[n][sum] == 1;
        }

        boolean take = false;
        if (arr[n] <= sum) {
            take = helperMM(arr, n - 1, sum - arr[n], dp);
        }

        boolean notTake = helperMM(arr, n - 1, sum, dp);

        dp[n][sum] = take || notTake ? 1 : 2;

        return take || notTake;

    }

    // Tabulation

    public static boolean canPartitionTB(int[] arr, int n) {
        System.out.println("hi");

        int sum = 0;
        for (int e : arr) {
            sum += e;
        }
        if (sum % 2 != 0) {
            return false;
        }
        System.out.println(sum);

        int t = sum / 2;

        boolean[][] dp = new boolean[n][t + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] < t + 1) {
            dp[0][arr[0]] = true;
        }

        for (boolean[] ar : dp) {
            System.out.println(Arrays.toString(ar));
        }
        System.out.println("--------------------------------------------------------");


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                boolean take = false;

                if (j - arr[i] >= 0) {
                    take = dp[i - 1][j - arr[i]];
                }

                boolean notTake = dp[i - 1][j];

                dp[i][j] = take || notTake;
            }

            for (boolean[] ar : dp) {
                System.out.println(Arrays.toString(ar));
            }
            System.out.println("--------------------------------------------------------");

        }
        return dp[n - 1][t];
    }

    // Space optimization

    public static boolean canPartitionSP(int[] arr, int n) {

        int sum = 0;
        for (int e : arr) {
            sum += e;
        }
        if (sum % 2 != 0) {
            return false;
        }
        //      System.out.println(sum);

        int t = sum / 2;

        boolean[] dp = new boolean[t + 1];
        boolean[] temp = new boolean[t + 1];

        dp[0] = true;
        temp[0] = true;

        if (arr[0] < t + 1) {
            dp[arr[0]] = true;
            temp[arr[0]] = true;
        }

        // boolean[] temp = Arrays.copyOfRange(dp,0,dp.length);

        for (int i = 1; i < n; i++) {

            for (int j = 1; j < dp.length; j++) {
                boolean take = false;

                if (j - arr[i] >= 0) {
                    take = dp[j - arr[i]];
                }

                boolean notTake = dp[j];

                temp[j] = take || notTake;
            }
            boolean[] t1 = dp;
            dp = temp;
            temp = t1;

        }


        return dp[n-1];
    }
}
