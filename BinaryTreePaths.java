import java.util.ArrayList;
import java.util.List;
public class BinaryTreePaths {
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
    public static void preorderModified(TreeNode root, List<String> res, String temp) {
        if (root.left == null && root.right == null) { /* Leaf node */
            temp = temp + root.val;
            res.add(temp);
            return;
        } else {
            temp = temp + root.val + "->";
            if (root.left != null)
                preorderModified(root.left, res, temp);
            if (root.right != null)
                preorderModified(root.right, res, temp);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        preorderModified(root, res, "");
        return res;
    }
}