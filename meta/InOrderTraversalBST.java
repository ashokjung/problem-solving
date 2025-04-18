package meta;

public class InOrderTraversalBST {

    private Integer prev = null;
    
    
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inOrder(root);
    }
    
    private boolean inOrder(TreeNode root){
    if(root == null){ return true;}
    if(!inOrder(root.left)){ return false; }   
    if(prev !=null && root.val <= prev){ return false; }
    prev = root.val;
    return inOrder(root.right);
    }
    public static void main(String[] args) {
        InOrderTraversalBST validator = new InOrderTraversalBST();

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
    }   
 

}
