package DSA.GreedyAlgo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class NMeetingsInARoom {
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 9, 5};
        int end[] =   {2, 4, 6, 7, 9, 9};

        System.out.println( maxMeetings(start,end));
    }

    public static int maxMeetings(int start[], int end[]) {
        // add your code here

        Map<Integer,Integer> map = new TreeMap<>();

        for (int i = 0; i < start.length; i++) {
            if(map.containsKey(end[i])){
                int val = map.get(end[i]);
                if(val<start[i]){
                    map.put(end[i],start[i]);
                }
            }else{
                map.put(end[i],start[i]);
            }
        }

        int f = 0;
        int c = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
           if(entry.getValue()>f){
               c++;
               f = entry.getKey();
           }
        }

        return c;
    }


}
