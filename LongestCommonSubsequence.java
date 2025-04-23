package DSA.DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(lcsSO("adebc","dcadb"));
    }
    public static int lcs(String s, String t) {
        return helper(s.length()-1, t.length()-1,s,t);
    }

    private static int helper(int i, int j, String s1, String s2) {
        if(i==-1 || j==-1){
            return 0;
        }

        if(s1.charAt(i)==s2.charAt(j)){
            return 1 + helper(i-1,j-1,s1,s2);
        }
        return Math.max(helper(i-1,j,s1,s2) , helper(i,j-1,s1,s2));
    }

    public static int lcsMM(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];

        int ans =  helperMM(s.length(), t.length(),s,t,dp);
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return ans;
    }

    private static int helperMM(int i, int j, String s1, String s2, int[][] dp) {
        if(i==0 || j== 0 ){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }

        if(s1.charAt(i-1)==s2.charAt(j-1)){
            dp[i][j] = 1 + helperMM(i-1,j-1,s1,s2, dp);
            return dp[i][j];
        }
        dp[i][j] = Math.max(helperMM(i-1,j,s1,s2, dp) , helperMM(i,j-1,s1,s2, dp));
        return dp[i][j];
    }


    public static int lcsTB(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];

        for (int i = 1; i <=s.length(); i++) {
            for (int j = 1; j <=t.length(); j++) {
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static int lcsSO(String s, String t) {
        int[] dp = new int[t.length()+1];
        int[] temp = new int[t.length()+1];

        for (int i = 1; i <=s.length(); i++) {
            for (int j = 1; j <=t.length(); j++) {
                if(s.charAt(i-1)==t.charAt(j-1)){
                    temp[j] = 1 + dp[j-1];
                }else {
                    temp[j] = Math.max(dp[j] , temp[j-1]);
                }
            }
            int[] tt = dp;
            dp = temp;
            temp = tt;
        }
        return dp[t.length()];
    }

    public static int lcsSOO(String s, String t) {
        int[] dp = new int[t.length()+1];


        for (int i = 1; i <s.length(); i++) {
            for (int j = i-1; j <=t.length(); j++) {
                if(s.charAt(i)==t.charAt(j)){
                    dp[j] = 1 + dp[j];
                }else {
                    dp[j] = Math.max(dp[i-1] , dp[j]);
                }
            }
        }
        return dp[t.length()];
    }

    public static int lcsSOPrint(String s, String t) {
        int[] dp = new int[t.length()+1];
        int[] temp = new int[t.length()+1];

        for (int i = 1; i <=s.length(); i++) {
            for (int j = 1; j <=t.length(); j++) {
                if(s.charAt(i-1)==t.charAt(j-1)){
                    temp[j] = 1 + dp[j-1];
                }else {
                    temp[j] = Math.max(dp[j] , temp[j-1]);
                }
            }
            int[] tt = dp;
            dp = temp;
            temp = tt;
        }
        return dp[t.length()];
    }


}
