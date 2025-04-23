package DSA.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AVL {

    public AVL(){}
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

    public int height(){
        return height(root);
    }
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
        return rotate(node);

    }

    private Node rotate(Node node) {

        if(height(node.left)-height(node.right) > 1){
            // left heavy
            if(height(node.left.left)-height(node.left.right)>0){
                // left - left case
              return rightRotate(node);
            }
            if(height(node.left.left)-height(node.left.right)<0){
                // left - right case
               node.left =  leftRotate(node.left);
               return rightRotate(node);
            }

        }

        if(height(node.right)-height(node.left) > 1){
            // right heavy
            if(height(node.right.right)-height(node.right.left)>0){
                // right - right case
               return leftRotate(node);
            }
            if(height(node.right.right)-height(node.right.left)<0){
                // right - left case
                node.right =  rightRotate(node.left);
                return leftRotate(node);
            }

        }
        
        return node;

    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        c.right = t;
        p.left = c;

        c.height = Math.max(height(c.left),height(c.right)) + 1;
        p.height = Math.max(height(p.left),height(p.right)) + 1;

        return p;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        c.height = Math.max(height(c.left),height(c.right)) + 1;
        p.height = Math.max(height(p.left),height(p.right)) + 1;

        return c;
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


// Tree Questions
    public List<Integer> bfs(){
        Queue<Node> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.value);
        queue.add(root);
        list = bfs(queue , list , queue.poll());
        return list;
    }

    private List<Integer> bfs(Queue<Node> queue, List<Integer> list, Node node) {

        if(node==null){
            return list;
        }

        if(node.left!=null) {
            queue.add(node.left);
            list.add(node.left.value);
        }

        if(node.right!=null) {
            queue.add(node.right);
            list.add(node.right.value);
        }

        return bfs(queue , list , queue.poll());
    }

    public List<List<Integer>> levelOrder() {

        List<List<Integer>> resList = new ArrayList<>();

        if(root == null){
             return resList;
        }

        Queue<Node> queue = new LinkedList<>();

       queue.offer(root);

       while (!queue.isEmpty()){
           int length = queue.size();
           List<Integer> list = new ArrayList<>();
           for (int i = 0; i < length; i++) {
               Node node = queue.poll();
               if(node == null){
                   continue;
               }
               queue.add(node.left);
               queue.add(node.right);
               list.add(node.value);
           }
           if(!list.isEmpty()){
               resList.add(list);
           }

       }

        return resList;
    }

    public List<Double> averageOfLevels() {

        List<Double> list = new ArrayList<>();

        if(root==null){
            return list;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int level = queue.size();
            double avg = 0;
            for (int i = 0; i < level; i++) {
                Node node = queue.poll();
                avg += node.value;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            avg /= level;

            list.add(avg);
        }
        return list;
    }


    public int levelOrderSuccessorNode(int val){

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){

                Node node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

                if(node.value == val){
                    return queue.peek() != null ? queue.peek().value : 0;
                }
        }

        return 0;
    }






}
