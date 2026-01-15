public class InvertBinaryTree {
    public static class TreeNode {
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
    public static TreeNode invert(TreeNode root) {
        if (root == null) return null;
        TreeNode leftSubtree = invert(root.left);
        TreeNode rightSubtree = invert(root.right);
        root.left = rightSubtree;
        root.right = leftSubtree;
        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        TreeNode newRoot = invert(root);
        return newRoot;
    }
}
