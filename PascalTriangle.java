package DSA.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
//pascal(5,5,3);


//        List<List<Integer>> li = generate(5);
//        System.out.println(li);

      //  System.out.println(nCr(5-1,3-1));

        System.out.println(generate3(5));

      //nthRowOfPascal(3);
    }

    public static void pascal(int n, int r, int c) {

        int[][] ar = new int[n][r];

        ar[0][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < r; j++) {
                if (j == 0) {
                    ar[i][j] = 1;
                } else if (ar[i - 1][j] == 0) {
                    ar[i][j] = 1;
                    break;
                } else {
                    ar[i][j] = ar[i - 1][j] + ar[i - 1][j - 1];
                }
            }
        }

        System.out.println("PRINTING (r,c) : " + ar[r - 1][c - 1]);


        System.out.println("PRINTING Nth row : " + Arrays.toString(ar[n - 1]));


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < r; j++) {
                if (ar[i][j] != 0) {
                    System.out.print(ar[i][j] + " ");
                } else if (ar[i][j] == 0) {
                    break;
                }
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(ar[i]));
        }
    }

    public static long nCr(int n, int r) {

        long res = 1;

        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }


    public static void  nthRowOfPascal(int n) {

        int ans = 1;

        System.out.print(ans + " ");

        for (int i = 1; i < n; i++) {
            ans = ans * (n-i);
            ans = ans / (i);

            System.out.print(ans + " ");

        }

    }

    public static List<List<Integer>> generate3(int n) {

        List<List<Integer>> li = new ArrayList<>();

        for (int i = 1; i <=n; i++) {
            List<Integer> temp = new ArrayList<>();
            int ans = 1;
            temp.add(ans);
            for (int j = 1; j < i; j++) {
                ans = ans * (i-j);
                ans = ans / (j);
                temp.add(ans);
            }
           li.add(temp);
        }
        return li;
    }
}
