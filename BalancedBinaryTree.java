public class BalancedBinaryTree {
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
    public static class Info {
        int depth;
        boolean isBalanced;
        public Info(int d, boolean b) {
            this.depth = d;
            this.isBalanced = b;
        }
    }
    public static Info balanced(TreeNode root) {
        if (root == null)
            return new Info(0, true);
        Info leftres = balanced(root.left);
        Info rightres = balanced(root.right);
        if (Math.abs(leftres.depth - rightres.depth) <= 1 && leftres.isBalanced && rightres.isBalanced)
            /* For a tree to be height balanced, the depth of its subtrees must not differ more than one and its left and right subtrees must be balanced */
            return new Info(Math.max(leftres.depth, rightres.depth)+1, true);
        else
            return new Info(Math.max(leftres.depth, rightres.depth)+1, false);
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Info res = balanced(root);
        return res.isBalanced;
    }
}