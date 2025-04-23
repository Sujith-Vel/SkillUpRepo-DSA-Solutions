package DSA.Random;

public class CountInversionsArray {
    public static void main(String[] args) {

        System.out.println(ans(new int[]{5,3,2,1,4}));

    }
    public static int ans(int[] ar){

        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i+1; j < ar.length ; j++) {
                if(ar[i]>ar[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
