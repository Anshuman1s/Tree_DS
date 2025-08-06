package TreeDS;
import java.util.*;
public class BinaryTree {
    public BinaryTree(){

    }
    private static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }
    private Node root;
    //insert data
    public void populate(Scanner sc){
        System.out.println("Enter the root Node");
        int data = sc.nextInt();
        root = new Node(data);
        populate(sc,root);
    }
    private void populate(Scanner sc, Node node){
//        insert for left
        System.out.println("Do you want to enter left of:" + node.data);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the value:" + node.data);
            int data = sc.nextInt();
            node.left = new Node(data);
            populate(sc,node.left);
        }
//        insert for right
        System.out.println("Do you want to enter right of:" + node.data);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the value:" + node.data);
            int data = sc.nextInt();
            node.right = new Node(data);
            populate(sc,node.right);
        }
    }
    public void display(){
        display(root,"");
    }
    private void  display(Node node , String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.data );
        display(node.left,indent + "\t");
        display(node.right , indent + "\t");
    }
    public void preetyDisplay(){
        preetyDisplay(root,0);
    }
    private void preetyDisplay(Node node, int level){
        if(node == null){
            return;
        }
        preetyDisplay(node.right, level+1);
        if(level != 0){
            for(int i = 0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.data);
        }else{
            System.out.println(node.data);
        }
        preetyDisplay(node.left,level+1);
    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree= new BinaryTree();
        tree.populate(sc);
//        tree.preetyDisplay();
        tree.preOrder();
    }
}
