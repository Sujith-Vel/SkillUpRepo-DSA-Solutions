package DSA.Random;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {


        System.out.println(Arrays.toString(mergeSort(new int[]{5,4,3,2,1})));

    }

    public static int[] mergeSort(int[] ar){

        if(ar.length==1){
            return ar;
        }

       int m = ar.length/2;
        int[] f = mergeSort(Arrays.copyOfRange(ar,0,m));
        int[] s = mergeSort(Arrays.copyOfRange(ar,m,ar.length));

        return merge(f,s);
    }

    private static int[] merge(int[] f, int[] s) {


       int n = Math.max(f.length, s.length);

       int i = 0;
       int j = 0;
       int k = 0;

       int[] ans = new int[f.length+s.length];

        for (; i < n; i++) {
            if(f[j]<s[k]){

                ans[i] = f[j];
                j++;
            }else {
              ans[i] = s[k];
              k++;
            }
        }

        while (j < f.length){
            ans[i] = f[j];
            j++;
            i++;
        }

        while (k< s.length){
            ans[i] = s[k];
            k++;
            i++;
        }

        return ans;

    }
}
