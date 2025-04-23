package DSA.Random;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum2(new int[]{1,1,1,1,1,4,1,1,1,1,1,7,1,1,1,1,1} , 11)));

    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new LinkedHashMap<>();
        List<Integer> keyList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i] , target-nums[i]);
           if( m.containsKey(target-nums[i]) ){
               keyList.clear();
              keyList.addAll(m.keySet());
               int pos = keyList.indexOf(target-nums[i]);
               if(pos != i) {
                   return new int[]{i, pos};
               }
           }
        }

        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> m = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(m.containsKey(target-nums[i])){
                return  new int[]{i,m.get(target-nums[i])};
            }
            m.put(nums[i] , i);
        }
        System.out.println(m);
        return new int[]{};
    }
}
