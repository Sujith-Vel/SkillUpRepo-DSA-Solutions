package DSA.GreedyAlgo;

import java.util.*;

public class FractionalKnapsack {

    public static void main(String[] args) {

     Integer val[] = {60, 100, 120};//{7,2,2,7,7,6,1,3,7,2};
        Integer wt[] = {10, 20, 30};//{7,2,7,5,6,6,2,7,5,7};
       int capacity = 50; // 27

        System.out.println(fractionalKnapsack2(new ArrayList<>(Arrays.asList(val)),new ArrayList<>(Arrays.asList(wt)),capacity));

    }

    public static double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here

        Map<Double , Product> map = new TreeMap<>(Collections.reverseOrder());


        for (int i = 0; i < val.size(); i++) {
            Product p = new Product(val.get(i),wt.get(i));
            map.put((double)val.get(i)/wt.get(i) , p);
        }

        for(Map.Entry<Double , Product> m : map.entrySet()){
            System.out.println(m.getKey() + " : wt : " + m.getValue().wt + " val : " + m.getValue().val);
        }

        System.out.println("================================================================");
        double ans = 0;

      for(Map.Entry<Double , Product> m : map.entrySet()){
          if(m.getValue().wt<=capacity){
              ans = ans + (double) m.getValue().val;
              System.out.println("get val : " + (double) m.getValue().val + " Ans : " + ans);
          }else {
              ans = ans + ( m.getKey() * capacity );
              System.out.println("get val : " +  m.getKey() + " c : " + capacity);
          }
          capacity = capacity - m.getValue().wt;
          if(capacity<0){
              break;
          }
      }

        return ans;
    }

    public static double fractionalKnapsack2(List<Integer> val, List<Integer> wt, int capacity) {

        Product [] arr = new Product[val.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Product(val.get(i), wt.get(i));
        }

        Arrays.sort(arr, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {

                double d1 = (double) p1.val/p1.wt;
                double d2 = (double) p2.val/p2.wt;
                return Double.compare(d2,d1);
            }
        });

        System.out.println(Arrays.toString(arr));

        double ans = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].wt<=capacity){
                ans = ans + arr[i].val;

                System.out.println(ans);

            }else {
                ans = ans + (((double) arr[i].val /arr[i].wt)*capacity);
                System.out.println(ans);
                return ans;
            }
            capacity = capacity-arr[i].wt;
        }

        return ans;
    }


}

