package DSA.Random;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

        System.out.println(longestConsecutive2(new int[]{100,4,200,1,3,2}));

    }

    public static int longestConsecutive(int[] nums) {

        // 2n logn
        Arrays.sort(nums);
        int count = 0;
        int ans = 0;
        for(int i =0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]-1 ){
                count++;
                if(ans<count){
                    ans=count;
                }
            }else{
                count = 0;
            }
        }
        return ans==0?0:ans+1;
    }
    public static int longestConsecutive2(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < set.size(); i++) {

        }

        return 0;
    }

}
