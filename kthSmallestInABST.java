import java.util.PriorityQueue;
public class kthSmallestInABST {
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
    public static void inorder(TreeNode root, PriorityQueue<Integer> pq) {
        if (root == null) return;
        inorder(root.left, pq);
        pq.add(root.val);
        inorder(root.right, pq);
    }
    public int kthSmallestNaiveApproach(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        inorder(root, pq);

        int kth = -1;
        for (int i=1; i<=k; i++)
            kth = pq.poll();
        return kth;
    }

    public static int nodesVisited = 0;
    public static int result = -1;
    public static void inorderOptimized(TreeNode root, int k) {
        if (root == null) return;
        inorderOptimized(root.left, k);
        nodesVisited++;
        if (nodesVisited == k) {
            result = root.val;
            return;
        }
        inorderOptimized(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        /* As we know, inorder traversal of a BST, always returns the answer in the sorted (ascending) order of the elements. So, if we can somehow keep a track of the current element number, a modified inorder traversal is sufficient to solve this problem */
        inorderOptimized(root, k);
        int res = kthSmallestInABST.result;
        kthSmallestInABST.nodesVisited = 0;
        kthSmallestInABST.result = -1;
        return res;
    }
}
