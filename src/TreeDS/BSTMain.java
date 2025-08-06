package TreeDS;

public class BSTMain {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nums = {5,2,7,1,4,6,9,8,3,10};
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
//        tree.populate(nums);
        tree.populateSorted(arr);
        tree.display();
        System.out.println(tree.balanced());
    }
}
