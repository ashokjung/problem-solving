package meta;

public class InOrderTraversalBST {

    private Integer prev = null;
    
    
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inOrderTraversal(root);
    }
    
    
}
