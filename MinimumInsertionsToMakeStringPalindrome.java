package DSA.DynamicProgramming;

public class MinimumInsertionsToMakeStringPalindrome {
    public static void main(String[] args) {

    }

    public static int minInsertion(String str) {
        // Write your code here.
        return str.length() - longestPalindromeSubsequenceSO(str);
    }

    public static int longestPalindromeSubsequenceSO(String s) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >=0 ; i--) {
            sb.append(s.charAt(i));
        }
        return longestCommonSubsequenceSO(s , String.valueOf(sb));
    }

    private static int longestCommonSubsequenceSO(String s1 , String s2) {

        int[] dp = new int[s2.length()+1];
        int[] temp = new int[s2.length()+1];

        for (int i = 1; i <=s1.length(); i++) {
            for (int j = 1; j <=s2.length(); j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    temp[j] = 1 + dp[j-1];
                }else {
                    temp[j] = Math.max(dp[j] , temp[j-1]);
                }
            }
            int[] t = dp;
            dp = temp;
            temp = t;
        }

        return dp[s2.length()];
    }
}
