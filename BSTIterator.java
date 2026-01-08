import java.util.ArrayList;

public class BSTIterator {
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
    int idx;
    ArrayList<Integer> inorder;
    private static void inorderTraversal(TreeNode root, ArrayList<Integer> inorder) {
        if (root == null) return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }
    public BSTIterator(TreeNode root) {
        this.idx = 0;
        this.inorder = new ArrayList<>();
        inorderTraversal(root, this.inorder);
    }
    public int next() {
        int val = this.inorder.get(this.idx);
        this.idx++;
        return val;
    }
    public boolean hasNext() {
        if (this.idx >= this.inorder.size()) /* If the idx is out of bounds, there no element next */
            return false;
        return true;
    }
}