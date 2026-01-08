import java.util.ArrayList;
public class LeafSimilarTrees {
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
    public static void getLeaf(TreeNode root, ArrayList<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        getLeaf(root.left, res);
        getLeaf(root.right, res);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaf1 = new ArrayList<>();
        ArrayList<Integer> leaf2 = new ArrayList<>();
        getLeaf(root1, leaf1);
        getLeaf(root2, leaf2);
        if (leaf1.size() != leaf2.size()) return false;
        int i = 0;
        while (i < leaf1.size()) {
            if ((int) leaf1.get(i) != (int) (leaf2.get(i))) /* If we didn’t use this ‘int’ typecast, an error would occur for the test case root1 = [1,2,200] and root2 = [1,2,200]. This is because leaf1.get(i) and leaf2.get(i) are Integer objects, and using != on objects compares references (memory addresses) rather than their actual values. Java caches Integer objects only for values between −128 and 127, so for values like 200, the two Integer objects are different in memory even though their values are the same. Casting to int forces unboxing to primitive int, ensuring that != compares the actual numeric values instead of object references, and thus the comparison works correctly for all values. */
                return false;
            i++;
        }
        return true;
    }
}