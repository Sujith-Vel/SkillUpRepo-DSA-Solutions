package DSA.Random;

public class GridUniquePaths {
    public static void main(String[] args) {
        //https://leetcode.com/problems/unique-paths/submissions/1405822716/
        System.out.println(uniquePaths(53,4));
    }

    public static int uniquePaths(int m, int n) {
       // return ans(m , n , 0 , 0);
        int[][] ar = new int[m][n];
        for(int i =0;i< ar.length;i++){
            for (int j = 0; j < ar[0].length; j++) {
                ar[i][j]=-1;
            }
        }
        return ans2(m , n , 0 , 0,ar);

    }

    private static int ans(int m, int n, int i, int j) {

        if(i==m || j==n) {
            return 0;
        }

        if(i==m-1 && j==n-1){
            return 1;
        }

        int left = ans(m,n,i+1,j);
        int right = ans(m,n,i,j+1);

        return left+right;
    }


    private static int ans2(int m, int n, int i, int j , int[][] ar) {

        if (i == m || j == n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (ar[i][j] != -1) {
            return ar[i][j];
        } else {

            int left = ans2(m, n, i + 1, j,ar);
            int right = ans2(m, n, i, j + 1,ar);
               ar[i][j] = left + right;
            return ar[i][j];
        }
    }

    public static int uniquePaths2(int m, int n) {

        int nn = m+n-2;
        int rr = m-1;
        double nCr = 1;

        for (int i = 0; i <rr; i++) {
            nCr = nCr*(nn-i);
            nCr = nCr/(i+1);
        }

        return  (int)Math.ceil(nCr);

    }
}
