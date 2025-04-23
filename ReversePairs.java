package DSA.Random;

import java.util.Arrays;

public class ReversePairs {
   static int count =0;
    public static void main(String[] args) {
        //https://leetcode.com/problems/reverse-pairs/description/

        System.out.println(reversePairs(new  int[]{1}));//2147483647,2147483647,2147483647,2147483647,2147483647,2147483647
    }

    public static int reversePairs1(int[] nums) {

        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {

                if(nums[i]>nums[j]*2){
                    c++;
                }
            }
        }
        return c;
    }
    public static int reversePairs(int[] nums) {

        System.out.println(Arrays.toString(mergeSort(nums)));
        System.out.println(nums.length);
        return count;
    }

    private static int[] mergeSort(int[] nums) {

        if(nums.length==1){
            return nums;
        }

        int mid = nums.length/2;
        int[] f = mergeSort(Arrays.copyOfRange(nums,0,mid));
        int[] s = mergeSort(Arrays.copyOfRange(nums,mid,nums.length));
        count = count + getCount(f , s );


        return merging(f , s);

    }

    private static int getCount(int[] f, int[] s) {
        int count = 0;
        int i = 0;
        int j = 0;
        while (i<f.length && j<s.length){
            if(f[i]>(long)s[j]*2){
                count++;
                j++;
            }else {
                i++;
                if(i<f.length){
                    count = count+j;
                }

            }
        }
        if(i<f.length-1 && j>s.length-1){
            int rem = f.length-i;
            count = count + (rem*count);
        }
        return count;
    }


    private static int[] merging(int[] f, int[] s) {

        int[] ar = new int[f.length+s.length];

        int i = 0;
        int j = 0;
        int k = 0;

      while (i<f.length && j<s.length){

          if(f[i]>s[j]){
              ar[k] = s[j];
              j++;
          }else {
              ar[k] = f[i];
              i++;
          }

          k++;

      }

        for (int l = i; l < f.length; l++) {
            ar[k] = f[l];
            k++;
        }

        for (int l = j; l <s.length; l++) {
            ar[k] = s[l];
            k++;
        }

        return ar;
    }

}
