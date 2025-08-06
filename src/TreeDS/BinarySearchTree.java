package TreeDS;
import java.util.*;
public class BinarySearchTree {
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
    public BinarySearchTree(){
    }
    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
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
        node.height = Math.max(height(node.left), height(node.right) +1);
        return node;
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
