package DSA.Random;

public class MaximumSubArray {
    public static void main(String[] args) {

       int a =  maxSubArrayOptimal(new int[]{-2,-1});
        System.out.println(a);
    }

    public static int maxSubArray(int[] nums) {

        if(nums.length==0){
            return 0;
        } else if (nums.length==1) {
            return nums[0];
        }

        int ans = Integer.MIN_VALUE;
            for (int j = 0; j < nums.length; j++) {
                int sum = 0;
                for (int k = j; k < nums.length; k++) {
                    sum = sum + nums[k];
                    if(ans<sum){
                        ans = sum;
                    }
                }
            }

        return ans;
    }

    public static int maxSubArrayOptimal(int[] nums) {

        int sum = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
                ans = ans + nums[i];
            if(ans>sum){
                sum = ans;
            }

            if(ans<0){
                ans = 0;
            }
        }

        return sum;

    }
}
