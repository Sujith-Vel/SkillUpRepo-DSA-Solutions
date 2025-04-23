package DSA.ArraysProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TrappingRainWater {
    public static void main(String[] args) {
//        System.out.println(trap(new int[]{4,2,0,3,2,5}));
        System.out.println(findDuplicates(new int[]{10,2,5,10,9,1,1,4,3,7}));
    }

    public static int trap(int[] ar) {

        int maxHeightBlock = 0;
        int areaOfBlocks = 0;
        int res = 0;
        int count = 0;

        for (int i = 0; i < ar.length; i++) {
            if(maxHeightBlock<=ar[i]){
                res = res + (maxHeightBlock * count) - areaOfBlocks;
                count = 0;
                maxHeightBlock = ar[i];
                areaOfBlocks = 0;
            }else {
                areaOfBlocks = areaOfBlocks + ar[i];
                count++;
            }
        }

        count = 0;
        areaOfBlocks = 0;
        int point = 0;

        for (int i = ar.length-1; i >= 0 ; i--) {

            if(point==maxHeightBlock){
                return res;
            }

            if(point<=ar[i]){
                res = res + (point * count) - areaOfBlocks;
                count = 0;
                point = ar[i];
                areaOfBlocks = 0;
            }else {
                areaOfBlocks = areaOfBlocks + ar[i];
                count++;
            }

        }

        return res;

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        int i = 0;
        int num = 1;

        while(i<nums.length){
            if(nums[i]==num){
                num++;
                i++;
            }else if(i>0 && nums[i]==nums[i-1]){
                i++;
            }else{
                list.add(num);
                num++;
            }

        }

        while(num-1<nums.length){
            list.add(num);
            num++;
        }



        return list;
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> h1 = new HashSet<>();
        HashSet<Integer> h2 = new HashSet<>();

        for (int val : nums1) {
            h1.add(val);
        }

        for (int val : nums2) {
            h2.add(val);
        }

        for (int val : h1) {
            if(h1.contains(val)){
                h1.remove(val);
                h2.remove(val);
            }
        }

        res.add(new ArrayList<>(h1));
        res.add(new ArrayList<>(h2));

        return res;

    }


    public  static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int n = nums[i]<0?nums[i]*-1:nums[i];
            if(nums[n-1]>0){
                nums[n-1] = nums[n-1]*-1;
            }else{
                list.add(n);
            }
        }
        return list;
    }

    }
