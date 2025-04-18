package meta;
class TreeNode{
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


public class FlattenBinaryTreeToLinkedList {

private TreeNode prev = null;
public void flatten(TreeNode root) {
    if (root == null) {
        return;
    }
    
    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;

    
}

public static void main(String[] args) {
    FlattenBinaryTreeToLinkedList flattener = new FlattenBinaryTreeToLinkedList();

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(6);

    flattener.flatten(root);

    // Print the flattened tree
    TreeNode current = root;
    while (current != null) {
        System.out.print(current.val + " ");
        current = current.right;
    }
}
}