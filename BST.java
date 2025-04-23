package DSA.BinaryTree;

public class BST {

    private static class Node{

        public Node(int value){
            this.value = value;
        }

        private int value;
        private Node left;
        private Node right;
        private int height;

        public int getValue() {
            return value;
        }
    }

    private Node root;

     public int height(Node node){
         if(node==null){
             return -1;
         }
         return node.height;
     }

     public boolean isEmpty(){
         return root==null;
     }

     public void insert(int value){
       root = insert(value , root);
     }

     private Node insert(int value , Node node){

         if(node==null){
             node = new Node(value);
             return node;
         }

         if(node.value>value){
             node.left = insert(value , node.left);
         }

         if(node.value<value){
             node.right = insert(value , node.right);
         }

         node.height = Math.max(height(node.left),height(node.right))+1;
         return node;

     }

     public boolean balanced(){
         return balanced(root);
     }

    private boolean balanced(Node node) {

         if(node == null){
             return true;
         }

         return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left)&& balanced(node.right);

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

    public void populate(int[] ar){
        for (int i = 0; i < ar.length ; i++) {
            this.insert(ar[i]);
        }
    }

    public int kthSmallest(int k ) {
         return kthSmallest(root,k);
    }

    int count = 0;
    private int kthSmallest(Node node, int k ) {
        node = kthSmallestt(root , k);
        return node.value;
    }

    public Node kthSmallestt(Node node, int k ) {
        if(node==null){
            return null;
        }

        Node left = kthSmallestt(node.left , k);
        if(left!=null){
            return left;
        }

        count++;
        if(count==k){
            return node;
        }

        return kthSmallestt(node.right , k);
    }

}
