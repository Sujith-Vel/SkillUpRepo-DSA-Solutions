package DSA.Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {
    public static void main(String[] args) {
// https://leetcode.com/problems/majority-element-ii/description/

        System.out.println(majorityElement2(new int[]{2,2,1,3}));

    }

    public static List<Integer> majorityElement(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int val = map.getOrDefault(nums[i],0);
            map.put(nums[i],val+1);

        }

        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if (e.getValue()>nums.length/3){
               list.add(e.getKey());
            }
        }

//        for(int i : nums){
//            System.out.println(nums[i]);
//        }
        return list;

    }

    public static List<Integer> majorityElement2(int[] nums) {

        int c1 = 0;
        int c2 = 0;
        int e1 = 0;
        int e2 = 0;

        for (int i = 0; i < nums.length; i++) {

            if(c1==0 && nums[i]!=e2){
                e1 = nums[i];
            }
           if(c2==0 && nums[i]!=e1){
                e2 = nums[i];
            }

            if(nums[i]==e1){
                c1++;
            }
            else if(nums[i]==e2){
                c2++;
            }else {
                c1--;
                c2--;
            }
        }

        List<Integer> list = new ArrayList<>();

        c1=0;
        c2=0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==e1){
                c1++;
            }else if(nums[i]==e2){
                c2++;
            }
        }

        if(c1>nums.length/3){
            list.add(e1);
        }
        if(c2>nums.length/3){
            list.add(e2);
        }

        return list;
    }

}
