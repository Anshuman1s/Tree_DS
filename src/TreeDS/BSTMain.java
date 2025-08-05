package TreeDS;

public class BSTMain {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nums = {5,2,7,1,4,6,9,8,3,10};
        tree.populate(nums);
        tree.display();
        System.out.println(tree.balanced());
    }
}
