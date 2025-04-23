package DSA.DynamicProgramming;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {

        int [] ar = {10,20,30,10};

       // System.out.println(frogJump2(4, ar));
        System.out.println(frogJumpUsingIteration(4,ar));

    }



    public static int frogJump(int n, int heights[]) {

        return frogJumpp(n-1,heights);
    }

    public static int frogJumpp(int n, int heights[] ) {
        if(n==0){
            return 0;
        }

        int ones = frogJumpp(n-1,heights ) + Math.abs(heights[n]-heights[n-1]);

        int twos = Integer.MAX_VALUE;
        if(n>1)
            twos =  frogJumpp(n-2,heights ) + Math.abs(heights[n]-heights[n-2]);

        return Math.min(ones , twos);
    }

    public static int frogJump2(int n, int heights[]) {

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJumpp2(n-1,heights,dp);
    }


    public static int frogJumpp2(int n, int heights[] , int[] dp) {
        if(n==0){
            return 0;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        int ones = frogJumpp2(n-1,heights , dp) + Math.abs(heights[n]-heights[n-1]);

        int twos = Integer.MAX_VALUE;
        if(n>1)
            twos =  frogJumpp2(n-2,heights , dp ) + Math.abs(heights[n]-heights[n-2]);

        dp[n] = Math.min(ones , twos);
        return dp[n];
    }


    public static int frogJumpUsingIteration(int n, int heights[]) {
        int p = 0;
        int pp = 0;

        for (int i = 1; i < n; i++) {
            int ones =  p + Math.abs(heights[i]-heights[i-1]);
            int twos = Integer.MAX_VALUE;
            if(i>1){
                twos =  pp + Math.abs(heights[i]-heights[i-2]);
            }

            int temp = p;
            p = Math.min(ones,twos);
            pp = temp;

        }

        return p;

    }

}



