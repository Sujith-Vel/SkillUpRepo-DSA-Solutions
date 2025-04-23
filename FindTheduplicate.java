package DSA.Random;

public class FindTheduplicate {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-the-duplicate-number/description/

        System.out.println(findDuplicate(new int[]{2,6,4,1,3,1,5}));
    }



    public static int findDuplicate(int[] nums) {

        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while ((slow!=fast));

        slow = 0;
        while ((slow!=fast)){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
