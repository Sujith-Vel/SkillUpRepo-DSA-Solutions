package DSA.Random;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 1}};
        //int[][] matrix = {{0, 1}};
        setZeroes3(matrix);
    }

    public static void setZeroes(int[][] matrix) {

        if (matrix.length < 1) {
            return;
        }
        int[][] ar = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            ar[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        ar[i][k] = 0;
                    }
                    for (int k = 0; k < matrix.length; k++) {
                        ar[k][j] = 0;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(ar));
    }


    public static void setZeroes2(int[][] matrix) {

        if (matrix.length < 1) {
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                    for (int k = 0; k < matrix[0].length; k++) {
                        if (matrix[i][k] != -1) {
                            matrix[i][k] = 0;
                        }
                    }
                    for (int k = 0; k < matrix.length; k++) {
                        if (matrix[k][j] != -1) {
                            matrix[k][j] = 0;
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setZeroes3(int[][] matrix) {

        if (matrix.length < 1) {
            return;
        }
        int[] row = new int[matrix[0].length];
        int[] col = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[j] = 1;
                    col[i] = 1;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
           if(row[i]==1){
               for (int j = 0; j < col.length; j++) {
                   matrix[j][i] = 0;
               }
           }
        }

        for (int i = 0; i < col.length; i++) {
            if(col[i]==1){
                for (int j = 0; j < row.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void setZeroes4(int[][] matrix) {
        if (matrix.length < 1) {
            return;
        }
        int[] row = new int[matrix[0].length];
        int[] col = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[j] = 1;
                    col[i] = 1;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if(row[i]==1){
                for (int j = 0; j < col.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 0; i < col.length; i++) {
            if(col[i]==1){
                for (int j = 0; j < row.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
