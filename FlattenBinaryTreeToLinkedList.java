public class FlattenBinaryTreeToLinkedList {
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

    public static TreeNode head = null;
    public static TreeNode tail = null;

    public static void preorder(TreeNode root) {
        if (root == null) return; /* null condition */

        /* handling the current node first */
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = null;

        if (head == null)
            head = tail = root;
        else {
            tail.right = root;
            tail = tail.right;
        }

        preorder(left);
        preorder(right);
    }
    public void flatten(TreeNode root) {
        FlattenBinaryTreeToLinkedList.head = FlattenBinaryTreeToLinkedList.tail = null;
        preorder(root);
    }
}
