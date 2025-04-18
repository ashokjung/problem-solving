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
public class BinaryTreeMaximumPathSum {
    
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
                sumFromSubtree(root);
                return maxSum;
    }

    private int sumFromSubtree(TreeNode root){

        if(root==null){
            return 0;
        }

        int leftSum = Math.max(sumFromSubtree(root.left), 0);
        int rightSum = Math.max(sumFromSubtree(root.right), 0);
        int currentSum = root.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, currentSum);
        return root.val + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, 
                            new TreeNode(2, 
                                new TreeNode(20), 
                                new TreeNode(1)
                            ), 
                            new TreeNode(10, 
                                null, 
                                new TreeNode(-25, 
                                    new TreeNode(3), 
                                    new TreeNode(4)
                                )
                            )
                        );

        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();
        System.out.println("Maximum Path Sum: " + solution.maxPathSum(root));
    }
}
