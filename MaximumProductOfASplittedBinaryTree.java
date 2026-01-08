public class MaximumProductOfASplittedBinaryTree {
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
    public static long getSum(TreeNode root) {
        if (root == null) return 0;
        long left = getSum(root.left);
        long right = getSum(root.right);
        return left + right + root.val;
    }
    public static long max = Long.MIN_VALUE;
    public static long maxUtil(TreeNode root, long sum) {
        if (root == null) return 0;
        long left = maxUtil(root.left, sum);
        long right = maxUtil(root.right, sum);
        long currsum = left + right + root.val;
        if (currsum * (sum - currsum) > MaximumProductOfASplittedBinaryTree.max)
            max = currsum * (sum - currsum);
        return currsum;
    }
    public int maxProduct(TreeNode root) {
        long sum = getSum(root);
        maxUtil(root, sum);
        long res = MaximumProductOfASplittedBinaryTree.max;
        MaximumProductOfASplittedBinaryTree.max = Long.MIN_VALUE;
        return (int) (res % (1e9+7));
    }
}