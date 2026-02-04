public class RootToLeafSum {
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
    public static int getSum1(TreeNode root, String path) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            /* Leaf node condition */
            path = path + root.val;
            return Integer.parseInt(path);
        }
        int leftSum = getSum1(root.left, path + root.val);
        int rightSum = getSum1(root.right, path + root.val);
        return leftSum + rightSum;
    }

    public static int getSum2(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            sum = (sum * 10) + root.val;
            return sum;
        }
        int leftSum = getSum2(root.left, sum * 10 + root.val);
        int rightSum = getSum2(root.right, sum * 10 + root.val);
        return leftSum + rightSum;
    }
    public int sumNumbers(TreeNode root) {
        return getSum2(root, 0);
    }
}
