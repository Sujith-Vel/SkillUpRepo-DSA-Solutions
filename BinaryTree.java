package DSA.BinaryTree;

import java.util.*;

public class BinaryTree {

    public Node root;

    public static class Node{

        public Node(int value){
            this.value = value;
        }

        int value;
        Node left;
        Node right;
    }


    public void populate(){
        System.out.println("Enter the root node : ");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        root = new Node(value);
        populate(root , sc);
    }

    private void populate(Node node, Scanner sc) {

        System.out.println("Do you want to add left node of " + node.value );
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the left value of "  + node.value);
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(node.left , sc);
        }

        System.out.println("Do you want to add right node of "  + node.value);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the right value of "  + node.value);
            int value = sc.nextInt();
            node.right = new Node(value);
            populate( node.right , sc);
        }
    }

    public void print(){
        print(root , "");
    }

    private void print(Node root , String indent) {
        if(root==null) return;
        System.out.println(indent + root.value);
        print(root.left, " ");
        print(root.right, " ");
    }


}
