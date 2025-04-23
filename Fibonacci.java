package DSA.DynamicProgramming;

import java.util.ArrayList;

public class Fibonacci {
   public static int[] ar;
    public static void main(String[] args) {
        // 0 , 1 , 1 , 2 , 3 , 5 , 8 , 13 , 21 ...
        // 0 , 1 , 2 , 3 , 4 , 5,  6 , 7 ,  8  , 9 , ...
        System.out.println(fiboNumUsingDp(8));
    }

    public static int fiboNumUsingDp(int n){

        ar = new int[n];


 return 0;

    }

    public static int fiboNum(int n ){

        if(n<=1){
            return n;
        }

        return fiboNum(n-1 ) + fiboNum(n-2 );
    }
}
