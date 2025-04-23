package DSA.Random;

import java.util.*;

public class MinimumSwapRequiredToSortArray {
    public static void main(String[] args) {
        Integer[] arr = {3 ,4 ,2 ,5,1};
      List<Integer> ar = Arrays.asList(arr);
//        ar.add(7);
//        ar.add(15);
//        ar.add(12);
//        ar.add(3);


        System.out.println(lilysHomework(ar));

    }

    public static int lilysHomework(List<Integer> arr) {

        HashMap<Integer,Integer > map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            map.put(arr.get(i) , i);
        }

       Collections.sort(arr);

        int i = 0;
        int count = 0;



        while (i<arr.size()){
            int val = map.get(arr.get(i));
            if(val==i){
                i++;
            }else{
                int temp = arr.get(i);
                arr.set(i,arr.get(val));
                arr.set(val , temp);
                    count++;
            }
        }

        arr.sort(Collections.reverseOrder());

        int i2 = 0;
        int count2 = 0;

        while (i2 <arr.size()){
            int val = map.get(arr.get(i2));
            if(val== i2){
                i2++;
            }else{
                int temp = arr.get(i2);
                arr.set(i2,arr.get(val));
                arr.set(val , temp);
                count2++;
            }
        }


        return Math.min(count , count2);
    }

    public static int gridLandMetro(int n, int m, int k, List<List<Integer>> track) {

        HashMap<Integer , int[]> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i, new int[2]);
        }

        for(int i=0;i<track.size();i++){
            int[] ar = map.get(track.get(i).get(0));
            if(ar[0]==0 && ar[1]==0){
                ar[0] = track.get(i).get(1);
                ar[1] = track.get(i).get(2);
            }else{
                if(ar[0]>track.get(i).get(1)){
                    ar[0]=track.get(i).get(1);
                }
                if(ar[1]>track.get(i).get(2)){
                    ar[1]=track.get(i).get(2);
                }
            }
            map.put(track.get(i).get(0), ar);
        }

        int count = 0;
        for(int i=1;i<=n;i++){
            int[] ar = map.get(i);
            if(ar[0]==0 && ar[1]==0){
                count+= m;
            }else{
                count += m - (ar[1]-ar[0]+1);
            }

        }

        return count;
    }

}
