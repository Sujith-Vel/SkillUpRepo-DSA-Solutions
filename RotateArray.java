package DSA.ArraysProblems;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
//        int [] nums = {1,2,3,4,5,6};
//        rotate(nums,2);
//        System.out.println(Arrays.toString(nums));

        String s = "Hello";
       s =  s.toLowerCase();
        System.out.println(s );



        System.out.println(isPalindrome("8V8K;G;K;V;"));

    }
    public static void rotate(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            int index = nums.length + i - k;

            index = index >= nums.length ? index - nums.length : index;

           // System.out.println(i + " -> " + index);

            System.out.print(nums[index] + " ");
        }
    }

    public static void rotate2(int[] nums, int k) {
        int index = nums.length - k;
        index = index >= nums.length ? index - nums.length : index;
        int temp1 = nums[index];
        int temp = 0;

        int j = 0;

        while (index != 0){
            temp = nums[index];

            int i = nums.length + index - k;
            i = i >= nums.length ? i - nums.length : i;
            nums[index] = nums[i];

            index = i;
            nums[index] = temp;
            j++;
        }
        nums[index] = temp1;

    }

    public static void rotate3(int[] nums, int k) {
        int temp1 = nums[nums.length-1];
        int temp = nums[1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1];
            nums[i+1] = temp;

        }
        nums[0] =temp1;

    }

    public static void rotate4(int[] nums, int k) {

        int[] helper = nums.clone();

        for (int i = 0; i < helper.length; i++) {
            int index = helper.length + i - k;

            index = index >= helper.length ? index - helper.length : index;

            nums[i] = nums[index] ;
        }
    }

    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();
        int i = 0;
        int j = s.length()-1;
        while(i<j){
           boolean check1 = (s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='0' && s.charAt(i)<='9') ;
           boolean check2 = (s.charAt(j)>='a' && s.charAt(j)<='z') || (s.charAt(j)>='0' && s.charAt(j)<='9') ;
            if(   check1 & check2 ){
                if(s.charAt(i)==s.charAt(j)){
                    i++;
                    j--;
                }else {
                    return false;
                }
            }else{
                if(!check1){
                    i++;
                }
                if(!check2){
                    j--;
                }
            }

        }

        return true;

    }

}
