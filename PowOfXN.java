package DSA.Random;

public class PowOfXN {
    public static void main(String[] args) {
        //https://leetcode.com/problems/powx-n/description/

        System.out.println(myPow(2.0,-5));

    }
    public static double myPow(double x, int n) {
        int nn = n;
        double ans = 1.0;
        while(n>1){
            if(n%2==0){
                x = x*x;
                n = n/2;
            }else{
                ans = ans *x;
                n = n-1;
            }
        }

        ans = ans * x;

        if(nn<0){
            return 1.0/ans;
        }

        return ans;
    }
}
