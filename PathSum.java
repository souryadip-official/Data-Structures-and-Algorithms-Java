public class PathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static boolean hasPathUtil(TreeNode root, int targetSum, int currSum) {
        if (root.left == null && root.right == null) /* leaf */
            return ((currSum + root.val) == targetSum? true : false); /* We need to include the leaf value as well */
        boolean leftSubtree = false, rightSubtree = false;
        if (root.left != null)
            leftSubtree = hasPathUtil(root.left, targetSum, currSum + root.val);
        if (root.right != null)
            rightSubtree = hasPathUtil(root.right, targetSum, currSum + root.val);
        return leftSubtree || rightSubtree;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        /* Beyond this, every tree has atleast a node */
        return hasPathUtil(root, targetSum, 0);
    }
}