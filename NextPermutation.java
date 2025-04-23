package DSA.Random;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        nextPermutation(new int[]{1,3,2});
    }
    public static void nextPermutation(int[] nums) {
        if(nums.length<=1){
            return;
        }
        int i ;
        for (i = 0; i < nums.length; i++) {
            if(i== nums.length-1){
                break;
            }
            if(nums[nums.length-1-i]>nums[nums.length-2-i]){
                int pos = 0;//chg
                int ans = Integer.MAX_VALUE;
                for (int j = nums.length-1-i; j < nums.length; j++) {
                    if(ans>nums[j] && nums[nums.length-2-i]<nums[j]){
                        ans=nums[j];
                        pos = j;
                    }
                }

                int temp = nums[pos];
                nums[pos] = nums[nums.length-2-i];
                nums[nums.length-2-i] = temp;
                break;

            }
        }

       Arrays.sort(nums,nums.length-1-i,nums.length);

        System.out.println(Arrays.toString(nums));
    }
}
