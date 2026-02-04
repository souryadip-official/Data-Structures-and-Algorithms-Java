public class ConstructStringfromBinaryTree {
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
        String res;
        boolean isAvailable;
        public Info (String res, boolean isAvailable) {
            this.res = res;
            this.isAvailable = isAvailable;
        }
    }
    public static Info tree2strUtil(TreeNode root) {
        if (root == null)
            return new Info("", false);

        if (root.left == null && root.right == null)
            return new Info(String.valueOf(root.val), true);

        String self = String.valueOf(root.val);
        Info left = tree2strUtil(root.left);
        left.res = "(" + left.res + ")";
        if (left.isAvailable && root.right == null)
            return new Info(self + left.res, true);

        Info right = tree2strUtil(root.right);
        right.res = "(" + right.res + ")";
        return new Info(self + left.res + right.res, true);
    }
    public String tree2str(TreeNode root) {
        return tree2strUtil(root).res;
    }
}
