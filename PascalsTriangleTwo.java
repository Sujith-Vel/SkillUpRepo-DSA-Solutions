package DSA.Random;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleTwo {
    public static void main(String[] args) {

        System.out.println(getRow(30));




    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();

        long ans = 1 ;
        int num = rowIndex+1;
        list.add((int)ans);

        for(int i = 1 ; i<rowIndex; i++){
            ans =  ans * (num - i) ;
            ans = ans / i;
            list.add((int)ans);
        }

        return list;

    }

    public static boolean judgeSquareSum(int c) {
        //The description needs to be improved, please mention that a == b is also possible and a,b >= 0.

        int n = (int) Math.sqrt(c);
        int i = 1;

        while (i<n){
            if(i*i + n*n == c){
                return true;
            }
            i++;
            n--;
        }

        return false;


    }

    public static boolean judgeSquareSum2(int c) {
        //The description needs to be improved, please mention that a == b is also possible and a,b >= 0.

        int n = (int) Math.sqrt(c)+1;

       int i = 0;

       while (i>n){
           if(i*i + n*n == c){
              return true;
           }else if(i*i + n*n > c){
               n--;
           } else {
               i++;
           }
       }
        return false;


    }
}
