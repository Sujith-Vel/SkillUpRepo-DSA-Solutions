package DSA.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {

        int[]  ar = {2,3,5};
     //   System.out.println(houseRobber(ar));
       // System.out.println(houseRobberUsingDp(ar));
        System.out.println(houseRobberUsingDpSpaceOpt2(ar));
    }

    public static long houseRobber(int[] valueInHouse) {
        return helper(valueInHouse , 0);
    }

    private static long helper(int[] valueInHouse, int i) {
        if(i==valueInHouse.length){
            return 0;
        }

        long max = valueInHouse[i];
        for (int k = i; k < valueInHouse.length; k++) {

            for (int j = k+2; j <valueInHouse.length ; j++) {
//                if(k == 0 && j == valueInHouse.length - 1){
//                    continue;
//                }
                long sum = valueInHouse[k] + helper(valueInHouse , j);
                if(max<sum)
                    max = sum;
            }
        }
        return max;
    }

    public static long houseRobberUsingDp(int[] valueInHouse) { // 13,24,34,47,56,61,73,84,99 => 262

        if(valueInHouse.length==0){
            return 0;
        }
        if(valueInHouse.length==2){
            return Math.max(valueInHouse[0] , valueInHouse[1]);
        }
        if(valueInHouse.length==1){
            return valueInHouse[0];
        }

        long[] dp = new long[valueInHouse.length];

        dp[dp.length-1] = valueInHouse[valueInHouse.length-1];
        dp[dp.length-2] = valueInHouse[valueInHouse.length-2];
        if(dp.length>3){
            dp[dp.length-3] = valueInHouse[dp.length-3] + dp[dp.length-1];
        }else {
            dp[dp.length-3] = valueInHouse[dp.length-3];
        }


        long maxi = Math.max(dp[dp.length-1] , Math.max(dp[dp.length-2] , dp[dp.length-3] ));

        for (int i = dp.length-4; i >=0; i--) {
            dp[i] = valueInHouse[i] + Math.max(dp[i+2] , dp[i+3]);
            if(i==0){
                dp[i] = dp[i] - dp[dp.length-1];
            }
            if(maxi<dp[i]){
                maxi = dp[i];
            }
        }
        return maxi;
    }

    public static long houseRobberUsingDpSpaceOpt(int[] valueInHouse) {
        if(valueInHouse.length==1){
            return valueInHouse[0];
        }
        int[] first = Arrays.copyOfRange(valueInHouse , 0 , valueInHouse.length-1);
        int[] second = Arrays.copyOfRange(valueInHouse , 1 , valueInHouse.length);

        return Math.max(maximumNonAdjacentSumUsingDpIterationOptSpace(first) , maximumNonAdjacentSumUsingDpIterationOptSpace(second));


    }

    public static long maximumNonAdjacentSumUsingDpIterationOptSpace(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }else if(nums.length==3){
            return Math.max(Math.max(nums[0] + nums[2],nums[1]),nums[2]);
        }


        long p = nums[nums.length-2];
        long pp = nums[nums.length-1];
        long cur = nums[nums.length-3] + pp;


        for (int k = nums.length-4; k >= 0; k--) {
            long temp = cur;
            cur = nums[k] + Math.max(p,pp);
            pp = p;
            p = temp;
        }

        return Math.max(cur , p);
    }

    // optimize the extra two arrays as well

    public static long houseRobberUsingDpSpaceOpt2(int[] valueInHouse) {
        if(valueInHouse.length==1){
            return valueInHouse[0];
        }

        long v1 = maximumNonAdjacentSumUsingDpIterationOptSpace2(valueInHouse , 0 , valueInHouse.length-2);
        long v2 = maximumNonAdjacentSumUsingDpIterationOptSpace2(valueInHouse , 1 , valueInHouse.length-1);

        System.out.println(v1);
        System.out.println(v2);

        return Math.max(v1,v2);
    }

    public static long maximumNonAdjacentSumUsingDpIterationOptSpace2(int[] nums , int start , int end) {
        if(end-start==0){
            return nums[start];
        }else if(end-start==1){
            return Math.max(nums[start],nums[start+1]);
        }else if(end-start==2){
            return Math.max(Math.max(nums[start] + nums[end],nums[start+1]),nums[end]);
        }


        long p = nums[end+1-2];
        long pp = nums[end+1-1];
        long cur = nums[end+1-3] + pp;


        for (int k = end+1-4; k >= start; k--) {
            long temp = cur;
            cur = nums[k] + Math.max(p,pp);
            pp = p;
            p = temp;
        }

        return Math.max(cur , p);
    }
}
