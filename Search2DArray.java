package DSA.Random;

public class Search2DArray {

    //https://leetcode.com/problems/search-a-2d-matrix/

    public static void main(String[] args) {

        int[][] matrix =  {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
     //  int[][] matrix = {{1}};

                System.out.println(searchMatrix(matrix , 25));


    }

        public static boolean searchMatrix(int[][] matrix, int target) {

            if(target<matrix[0][0]){
                return false;
            }

            int max = Integer.MIN_VALUE;
            int i = 0;
            for(; i<matrix.length;i++){
                if(matrix[i][0]<=target && matrix[i][0]>max){
                    max = matrix[i][0];

                }else{
                    break;
                }
            }

            i = i-1;
            int s = 0;
            int e = matrix[0].length-1;

            while(s<=e){
                int m = (s+e)/2;
                if(target>matrix[i][m]){
                    s = m+1;
                }
                else if(target<matrix[i][m]){
                    e = m-1;
                }
                else{
                    return true;
                }
            }
            return false;
        }


}
