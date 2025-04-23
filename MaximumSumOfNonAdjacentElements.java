package DSA.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumOfNonAdjacentElements {
    public static void main(String[] args) {

        Integer[] ar = {1,2,3,4,5}; //291 = 288

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(ar));
        ArrayList<Integer> res = new ArrayList<>();

      //  printNums(list , 0);
       // System.out.println(sumOfNumsInListStartFromEveryNum(list , list.size()-1 , res , 0));

//        System.out.println(maximumNonAdjacentSum(list));
//        System.out.println(maximumNonAdjacentSumUsingDp(list));
//        System.out.println(maximumNonAdjacentSumUsingDpIteration(list));
        System.out.println(maximumNonAdjacentSumUsingDpIterationOptSpace(list));
       // System.out.println(maximumNonAdjacentSumUsingDpIterationOptSpace(list));

    }

    private static List<Integer> sumOfNumsInListStartFromEveryNum(ArrayList<Integer> list, int i , ArrayList<Integer> res , int sum) {
       if(i==-1){
           return res;
       }
       sum = sum + list.get(i);
        res.add(sum);
       sumOfNumsInListStartFromEveryNum(list , i-1 , res , sum);
       return res;

    }



    private static int sumOfNums(ArrayList<Integer> list, int i) {
        if(i==list.size()){
            return 0;
        }
        return list.get(i) + sumOfNums(list , i+1);
    }


    private static int sumOfAlternativeNums(ArrayList<Integer> list, int i) {
        if(i==list.size()){
            return 0;
        }
        return list.get(i) + sumOfAlternativeNums(list , i+2);
    }

    public static void printNums(ArrayList<Integer> nums , int i) {
        if(i==nums.size()){
            return;
        }
        System.out.println(nums.get(i));
        printNums(nums , i+1);
    }



// {3, 10, 10, 7}
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        if(nums.size()==1){
            return nums.getFirst();
        }
        if(nums.size()==2){
            return Math.max(nums.get(0),nums.get(1));
        }
        return helper(nums , 0);
    }

    private static int helper(ArrayList<Integer> nums, int i) {
        if(i==nums.size()){
            return 0;
        }

        int max = nums.get(i);
        for (int k = i; k < nums.size(); k++) {

            for (int j = k+2; j <nums.size(); j++) {

                int sum = nums.get(k) + helper(nums , j);
                if(max<sum){
                    max = sum;
                }
            }

        }

        return max;
    }

    // Changing the code to DP soln

    public static int maximumNonAdjacentSumUsingDp(ArrayList<Integer> nums) {
        if(nums.size()==1){
            return nums.getFirst();
        }
        if(nums.size()==2){
            return Math.max(nums.get(0),nums.get(1));
        }
        int[] dp = new int[nums.size()];
        Arrays.fill(dp,-1);

        int val = helperr(nums , 0 , dp);
        System.out.println(Arrays.toString(dp));
        return val;
    }

    private static int helperr(ArrayList<Integer> nums, int i , int[] dp) {
        if(i==nums.size()){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int max = nums.get(i);
        for (int k = i; k < nums.size(); k++) {

            for (int j = k+2; j <nums.size(); j++) {

                int sum = nums.get(k) + helperr(nums , j , dp);
                if(max<sum){
                    max = sum;
                }
            }
        }

        dp[i] = max;

        return max;
    }

    // Changing DP recursion to iteration

    public static int maximumNonAdjacentSumUsingDpIteration(ArrayList<Integer> nums) {
        if(nums.size()==1){
            return nums.getFirst();
        }
        if(nums.size()==2){
            return Math.max(nums.get(0),nums.get(1));
        }
        int[] dp = new int[nums.size()];

        dp[nums.size()-1] = nums.get(nums.size()-1);
        dp[nums.size()-2] = nums.get(nums.size()-2);


        int max = 0;
        for (int k = nums.size()-3; k >= 0; k--) {

            for (int j = k+2; j <nums.size(); j++) {
                int sum = nums.get(k) + dp[j];
                if(max<sum){
                    max = sum;
                }
            }
            dp[k] = max;
        }

      //  System.out.println(Arrays.toString(dp));

        return Math.max(dp[0],dp[1]);
    }

    // Optimizing the space of DP iteration Solution


    public static int maximumNonAdjacentSumUsingDpIterationOptSpace(ArrayList<Integer> nums) {
        if(nums.size()==1){
            return nums.getFirst();
        }else if(nums.size()==2){
            return Math.max(nums.get(0),nums.get(1));
        }else if(nums.size()==3){
            return Math.max(Math.max(nums.get(0) + nums.get(2),nums.get(1)),nums.get(2));
        }


        int p = nums.get(nums.size()-2);
        int pp = nums.get(nums.size()-1);
        int cur = nums.get(nums.size()-3) + pp;


        for (int k = nums.size()-4; k >= 0; k--) {
                int temp = cur;
                cur = nums.get(k) + Math.max(p,pp);
                pp = p;
                p = temp;
        }


        return Math.max(cur , p);
    }

}
