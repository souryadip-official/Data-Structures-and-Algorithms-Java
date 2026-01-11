import java.util.ArrayList;
public class MinimumAbsoluteDifferenceinBST {
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
    public static void inorderTraversal(TreeNode root, ArrayList<Integer> inorder) {
        if (root == null)
            return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }
    public int getMinimumDifference(TreeNode root) {
        /* Perform the in-order traversal which returns the elements in a sorted fashion or use a min-heap */
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        if (inorder.size() < 2) return -1;
        int minAbsDiff = Integer.MAX_VALUE;
        for (int i=0; i<inorder.size()-1; i++) {
            int currDiff = Math.abs(inorder.get(i)-inorder.get(i+1));
            minAbsDiff = Math.min(minAbsDiff, currDiff);
        }
        return minAbsDiff;
    }
}