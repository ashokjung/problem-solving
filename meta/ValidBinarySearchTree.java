package meta;
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

public class ValidBinarySearchTree{

public boolean isValidBST(TreeNode root) {
    return validate(root , null , null);
}

 public boolean validate(TreeNode node , Integer lower , Integer upper){
   
    // Empty tree is a valid BST

    if(node == null ) { return true; }

    // The Current Node's Value must be between low and high

    if((lower!= null && node.val <= lower)||
    (upper!= null && node.val >= upper))
    {
        return false;
    }

    return validate(node.left , lower , node.val) && 
           validate(node.right , node.val , upper);

}
public static void main(String[] args) {
    ValidBinarySearchTree validator = new ValidBinarySearchTree();

    // Example 1: Valid BST
    TreeNode root1 = new TreeNode(2);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(3);
    System.out.println("Is valid BST? " + validator.isValidBST(root1)); // Output: true

    // Example 2: Invalid BST
    TreeNode root2 = new TreeNode(5);
    root2.left = new TreeNode(1);
    root2.right = new TreeNode(4);
    root2.right.left = new TreeNode(3);
    root2.right.right = new TreeNode(6);
    System.out.println("Is valid BST? " + validator.isValidBST(root2)); // Output: false

    // Setting a TreeNode to null
    TreeNode root3 = null;
    System.out.println("Is valid BST? " + validator.isValidBST(root3)); // Output: true
}
}