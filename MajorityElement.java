package DSA.Random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        // https://leetcode.com/problems/majority-element/

        System.out.println(mooreVotingAlgo(new int[]{2,2,1,1,1,2,2}));

    }

    public static int majorityElement(int[] nums) {

        Arrays.sort(nums);

        int m = nums.length / 2;

        int s1 = 0, s2 = m;
        int e1 = m, e2 = nums.length - 1;
        int m1 = 0;
        while (s1 < e1) {
            m1 = (s1 + e1) / 2;

            if (nums[m1] <= nums[m] && m - m1 > 1) {
                s1 = m1 + 1;
            } else if (nums[m1] > nums[m]) {
                e1 = m1 - 1;
            } else if (nums[m1] < nums[m] && m - m1 == 1) {
                m1 = m1 + 1;
                break;
            }
        }
        int m2 = 0;
        while (s2 < e2) {
            m2 = (s2 + e2) / 2;

            if (nums[m2] >= nums[m]) {
                s2 = m2 + 1;
            } else if (nums[m2] <= nums[m] && m2 - m == 1) {
                e2 = m2 - 1;
            } else if (nums[m2] < nums[m] && m - m2 == 1) {
                m2 = m2 - 1;
                break;
            }
        }

        if (m2 - m1 > nums.length / 2) {
            return nums[m];
        }
        return 0;
    }


    public static int majorityElementUsingMap(int[] nums) {


        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], value + 1);
        }

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() > nums.length / 2) {
                return it.getKey();
            }
        }
        return 0;
    }

    public static int ans(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int en = map.getOrDefault(nums[i], 0);
            map.put(nums[i], en + 1);
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > nums.length / 2) {
                return m.getKey();
            }
        }

        return 0;

    }
    public static int mooreVotingAlgo(int[] nums) {

        //https://youtu.be/gY-I8uQrCkk?si=n9dmILLMK0SxTz3V
        int ans = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count==0){
                ans = nums[i];
            }
            if(ans == nums[i]){
                count++;
            }else {
                count--;
            }
        }
        return ans;
    }


}

