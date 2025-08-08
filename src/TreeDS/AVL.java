package TreeDS;

import java.util.*;
public class AVL {
    public class Node{
        private int data;
        private int height;
        private Node left;
        private Node right;
        public Node(int data){
            this.data = data;
        }
        public int getData(){
            return data;
        }
    }
    private Node root;
    public AVL(){
    }
    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }
    public int height(){
        return height(root);
    }
    public boolean isEmpty(){
        return root == null;
    }
    //    insert
    public void insert(int data){
        root = insert(data, root);
    }
    private Node insert(int data, Node node){
        if(node == null){
            node = new Node(data);
            return node;
        }
        if(data< node.data){
            node.left = insert(data,node.left);
        }
        if(data > node.data){
            node.right = insert(data,node.right);
        }
        node.height = Math.max(height(node.left), height(node.right))+1;
        return rotate(node);
    }
    private Node rotate(Node node){
        //            left heavy
        if(height(node.left) - height(node.right) > 1) {
//left-left case
            if(height(node.left.left) - height(node.left.right)>0){
                return rightRotate(node);
            }
//            left right case
            if(height(node.left.left) - height(node.left.right)<0){
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right) < -1) {
            //        right heavy
            if(height(node.right.left) - height(node.right.right)<0){
//                right-right case
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right)>0){
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    public Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;
        c.right = p;
        p.left = t;
        p.height = Math.max(height(p.left) , height(p.right) +1);
        c.height = Math.max(height(c.left) , height(c.right) +1);
        return c;
    }
    public Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;
        p.left = c;
        c.right = t;
        p.height = Math.max(height(p.left) , height(p.right) +1);
        c.height = Math.max(height(c.left) , height(c.right) +1);
        return p;
    }
    public void populate(int[] arr){
        for(int i =0;i<arr.length;i++){
            this.insert(arr[i]);
        }
    }
    //    For sorted data
    public void  populateSorted(int[] arr){
        populateSorted(arr,0,arr.length);
    }
    private void populateSorted(int [] arr, int start , int end){
        if(start >= end){
            return;
        }
        int mid = (start  + end)/2;
        this.insert(arr[mid]);
        populateSorted(arr,start,mid);
        populateSorted(arr,mid+1,end);
    }
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
    public void display(){
        display(root,"Root Node: ");
    }
    public void display(Node node,String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.getData());
        display(node.left , "Left child of " +  node.getData()  + " : ");
        display(node.right , "Right child of " +  node.getData()  + " : ");
    }
}

