package DSA.DynamicProgramming;

public class NinjaTraining {
    public static void main(String[] args) {
    int[][] points = {{10,40,70},
            {20,50,80},
            {30,60,90}};
        System.out.println(ninjaTraining(3,points));
    }
    public static int ninjaTraining(int n, int points[][]) {

        int first = points[points.length-1][0];
        int second = points[points.length-1][1];
        int third = points[points.length-1][2];

        for (int i = points.length-2; i >=0 ; i--) {
            int t1 =0;
            int t2 =0;
            int t3 =0;
            for (int j = 0; j < 3; j++) {
                if(j==0){
                    t1 = points[i][j] + Math.max(second , third);
                } else if (j==1) {
                    t2 = points[i][j] + Math.max(first , third);
                }else {
                    t3 = points[i][j] + Math.max(first , second);
                }
            }
             first = t1;
             second = t2;
             third = t3;
        }

        return Math.max(Math.max(first,second),third);
    }
}
