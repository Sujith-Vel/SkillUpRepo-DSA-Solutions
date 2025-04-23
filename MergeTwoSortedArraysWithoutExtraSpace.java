package DSA.Random;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {

        long[] a = {2, 3, 4, 5};
        long[] b =  {1, 8, 8};

        mergeTwoSortedArraysWithoutExtraSpace(a,b);
    }

    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        // Write your code here.

        for (int i = 0; i < a.length; i++) {
            if(i==b.length){
                break;
            }
            if(a[a.length-1-i]>b[i]){
                long temp = a[a.length-1-i];
                a[a.length-1-i] = b[i];
                b[i] = temp;
            }else {
                break;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);

        System.out.println(Arrays.toString(a) + Arrays.toString(b) );
    }
}
