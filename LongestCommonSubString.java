package DSA.DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubString {
    public static void main(String[] args) {

        System.out.println(lcsSOO("abbedabdaec","bebccc"));

    }
    public static int lcs(String str1, String str2){
        int[][]dp = new int[str1.length()+1][str2.length()+1];
        int max = -1;

        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(max<dp[i][j]){
                        max = dp[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {

                System.out.println(Arrays.toString(dp[i]));

        }

        return max;
    }

    public static int lcsSO(String str1, String str2){
        int[]dp = new int[str2.length()+1];
        int[]temp = new int[str2.length()+1];
        int max = -1;

        for(int i=1;i<=str1.length();i++){
            temp = dp;
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[j] = 1 + temp[j-1];
                    if(max<dp[j]){
                        max = dp[j];
                    }
                }
            }

        }

        return max;
    }

    public static int lcsSOO(String str1, String str2){
        int[]dp = new int[str2.length()+1];
        int[] temp =  new int[str2.length()+1];
        int max = -1;

        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    temp[j] = 1 + dp[j-1];
                    if(max<temp[j]){
                        max = temp[j];
                    }
                }else {
                    temp[j] = 0;
                }
            }
            int[] t = dp;
            dp = temp;
            temp = t;
        }

        return max;
    }





    public static String lcsPrint(String str1, String str2){
        int[][]dp = new int[str1.length()+1][str2.length()+1];
        int max = -1;
        int indI = 0;

        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(max<dp[i][j]){
                        max = dp[i][j];
                        indI = i;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (max>0){
            sb.insert(0,str1.charAt(indI-1));
            indI--;
            max--;
        }

        return String.valueOf(sb);
    }
}
