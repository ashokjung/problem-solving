// Definition for a binary tree node.
package oca;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeastCommonAncestor {
    // Function to find LCA
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or root is either p or q
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Recur for left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both left and right are not null, then root is the LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Otherwise, return the non-null subtree (left or right)
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        // Create a simple binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Create nodes to test
        TreeNode p = root.left;  // Node 5
        TreeNode q = root.left.right.right;  // Node 4

        // Create an instance of Solution and find the LCA
        LeastCommonAncestor solution = new LeastCommonAncestor();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        // Output the result
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val);
    }
}
