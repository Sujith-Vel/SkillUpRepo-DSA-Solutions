package DSA.Random;

import java.util.Arrays;

public class SortArray012 {
    public static void main(String[] args) {
    sortColorsOptimal(new int[]{2,0,2,1,1,0});

    }
    public static void sortColors(int[] nums) {

        int count0 = 0;
        int count1 = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                count0++;
            } else if (nums[i]==1) {
                count1++;
            }
        }

        for (int i = 0; i < count0; i++) {
            nums[i]=0;
        }
        for (int i = count0; i < count0+count1; i++) {
            nums[i]=1;
        }
        for (int i = count0+count1; i < nums.length; i++) {
            nums[i]=2;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void sortColorsOptimal(int[] nums){

      int mid = 0;
      int low = 0;
      int high = nums.length-1;

        while (high>=mid){
            if(nums[mid]==0){
                swap(nums , mid , low);
                mid++;
                low++;
            } else if (nums[mid]==1) {
               mid++;
            }else {
                swap(nums,mid,high);
                high--;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int mid, int low) {
        int temp = nums[mid];
        nums[mid] = nums[low];
        nums[low] = temp;
    }


}
