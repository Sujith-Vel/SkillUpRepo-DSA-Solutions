package DSA.DynamicProgramming;

public class MaximumChocolates {
    public static void main(String[] args) {
        int[][] grid =  {{2, 3, 1, 2}, {3, 4, 2, 2}, {5, 6, 3, 5}};
//        int[][] grid =  {{1,2,3}, {4,5,6} , {7,8,9}};
      //  int[][] grid =  {{15}};

        System.out.println(maximumChocolatesDP(0,0,grid));
        int v = (int) -1e8;
    }

    public static int maximumChocolates(int r, int c, int[][] grid) {
        return  helperFun(grid  , 0 , 0 , grid[0].length-1);
    }

    private static int helperFun(int[][] grid, int i, int j1 , int j2) {

        if(j1<0 || j2<0 || j1>grid[0].length-1 || j2>grid[0].length-1){
            return Integer.MIN_VALUE;
        }

        if(i == grid.length-1 ){
            if(j1==j2){
                return grid[i][j2];
            }
            return grid[i][j1] + grid[i][j2];
        }

       long max = 0;
        for (int x = -1; x <=1 ; x++) {
            for (int y = -1; y <=1 ; y++) {
                long val = 0;
                if(j1==j2){
                     val =  grid[i][j1] + helperFun(grid ,i+1 , j1+x , j2+y);
                }else{
                     val = grid[i][j1] + grid[i][j2] + helperFun(grid ,i+1 , j1+x , j2+y);
                }

                if(max<val){
                    max = val;
                }

            }
        }
        return (int)max;
    }

    // Using DP

    public static int maximumChocolatesDP(int r, int c, int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        return  helperFunDp(grid  , 0 , 0 , grid[0].length-1 , dp);
    }

    private static int helperFunDp(int[][] grid, int i, int j1 , int j2 ,  int[][][] dp) {

        if(j1<0 || j2<0 || j1>grid[0].length-1 || j2>grid[0].length-1){
            return Integer.MIN_VALUE;
        }

        if(i == grid.length-1 ){
            if(j1==j2){
                return grid[i][j2];
            }
            return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2]!=0){
            return dp[i][j1][j2];
        }

        long max = 0;
        for (int x = -1; x <=1 ; x++) {
            for (int y = -1; y <=1 ; y++) {
                long val = 0;
                if(j1==j2){
                    val =  grid[i][j1] + helperFunDp(grid ,i+1 , j1+x , j2+y , dp);
                }else{
                    val = grid[i][j1] + grid[i][j2] + helperFunDp(grid ,i+1 , j1+x , j2+y , dp);
                }

                if(max<val){
                    max = val;
                }
            }
        }

        dp[i][j1][j2] = (int) max;

        return dp[i][j1][j2];
    }
}
