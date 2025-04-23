package DSA.Random;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        //https://leetcode.com/problems/rotate-image/submissions/1371732083/

        /*
        * Key point -> step 1 : first transpose the array
        *           -> step 2 : interchange the columns or reverse every rows
        * */
      int[][] m = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
      rotate(m);

    }

    public static void rotate(int[][] matrix) {


        //step 1 : first transpose the array
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //step 2 : interchange the columns or reverse every rows
        // Here interchanging columns i.e -> 1st col <-> nth col , 2nd col <-> n-1th col ..etc
        for (int j = 0; j < matrix.length/2; j++) {
            for (int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] =  temp;
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }



    }

}
