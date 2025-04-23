package DSA.BinaryTree;

public class SegmentTree {

    public SegmentTree(){

    }

    private static class Node{
        private int start;
        private int end;
        private int value;
        private Node left;
        private Node right;

        public Node(int start , int end){
            this.start = start;
            this.end = end;
        }

        public int getValue(){
            return value;
        }
    }

   private Node root;

    public void insertArray(int[] ar){
        root = insertArray(0,ar.length-1 , ar);
    }

    private Node insertArray(int i, int j , int[] ar) {

        if(i==j){
            Node n = new Node(i , j);
            n.value = ar[i];
            return n;
        }

        int mid = (i+j)/2;
        Node n = new Node(i,j);
        n.left = insertArray(i,mid , ar);
        n.right = insertArray(mid+1,j , ar);

        n.value = n.left.value + n.right.value;

        return n;
    }

    public void display(){
        display(this.root , "The root node : ");
    }

    private void display(Node node, String details) {
        if(node==null){
            return;
        }

        System.out.println(details + node.value );
        display(node.left , "The left child of " + node.value + " : ");
        display(node.right , "The right child of " + node.value + " : ");
    }

    public int query(int start , int end){
      return query(root , start , end);
    }

    private int query(Node node, int start, int end) {
         if(node.start>=start && node.end<= end){
             return node.value;
         } else if (node.start>end || node.end < start) {
             return 0;
         }else {
             return query(node.left , start , end ) + query(node.right , start , end);
         }
    }

// Mistake
//    public void update(int index , int num ){
//       root.value = root.value + update(root , index , num , 0) ;
//    }
//
//    private int update(Node node, int index, int num , int n) {
//        if(node.start == node.end){
//             n = num - node.value;
//             node.value = num;
//            return n;
//        }
//        int  mid = (node.start + node.end)/2;
//        if(index<=mid){
//            node.value =  node.value + update(node.left , index , num , n);
//            return n;
//        }else {
//           node.value =  node.value + update(node.right , index , num , n) ;
//           return n;
//        }



    // Correct Version
    public void update(int index , int num ){

        update(root , index , num );
    }

    private int update(Node node, int index, int num ) {
        if(node.start == node.end){
            int delta  = num - node.value;
            node.value = num;
            return delta;
        }

        int  mid = (node.start + node.end)/2;
        int delta;
        if(index<=mid){
            delta = update(node.left , index , num );
        }else {
            delta = update(node.right , index , num );
        }

        node.value = node.value + delta;

        return delta;
    }

//     Observation and ChatGpt Suggestions
//
//    1. Understand How Values Propagate**
//            - Instead of passing extra variables (`n` in your case), **return the necessary values** (`delta`) from recursion.
//            - Always **think about what needs to be updated at each level**.
//
//            #### **2. Identify Base and Recursive Cases Properly**
//            - Base Case: If you reach the leaf node (`node.start == node.end`).
//            - Recursive Case: Update either the left or right child based on `index`.
//
//            #### **3. Avoid Redundant Computations**
//            - Instead of updating `root.value` separately, let recursion handle it.
//            - Always update the current node **after** processing child nodes.
//
//---
//
//        ### **Key Takeaways**
//            ✅ Always return computed values instead of relying on function arguments for updates.
//            ✅ Ensure each recursive call modifies parent nodes correctly.
//            ✅ Use simple, clear logic: **Find → Update → Propagate Upwards**.
//
//       With these principles in mind, your recursion skills will improve significantly! 🚀

}
