import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class RightViewOfBinaryTree {
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
        TreeNode node;
        int level;
        public Info(TreeNode n, int l) {
            this.node = n;
            this.level = l;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return res;
        }
        // Level Order Traversal (Rightmost node at each level)
        ArrayList<Info> arr = new ArrayList<>();
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(root, 0));
        while (!queue.isEmpty()) {
            Info curr = queue.poll();
            arr.add(curr);
            if (curr.node.left != null)
                queue.add(new Info(curr.node.left, curr.level+1));
            if (curr.node.right != null)
                queue.add(new Info(curr.node.right, curr.level+1));
        }
        /* Now, we take the rightmost node of each level */
        int prevLevel = 0;
        int prevValue = -1;
        for (int i=0; i<arr.size(); i++) {
            Info currnode = arr.get(i);
            if (currnode.level == prevLevel) {
                prevLevel = currnode.level;
                prevValue = currnode.node.val;
            }
            else {
                res.add(prevValue);
                prevLevel = currnode.level;
                prevValue = currnode.node.val;
            }
        }
        res.add(prevValue);
        return res;
    }
}