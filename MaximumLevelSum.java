import java.util.Queue;
import java.util.LinkedList;
public class MaximumLevelSum {
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
        Info(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public int maxLevelSum(TreeNode root) {
        Queue<Info> queue = new LinkedList<>();
        TreeNode temp = root;
        queue.add(new Info(temp, 1));
        int maxLevel = -1;
        int maximumLevelSum = Integer.MIN_VALUE;
        int currLevelSum = 0;
        int currLevel = 1;
        while (!queue.isEmpty()) {
            Info currEle = queue.poll();
            if (currEle.node.left != null)
                queue.add(new Info(currEle.node.left, currEle.level+1));
            if (currEle.node.right != null)
                queue.add(new Info(currEle.node.right, currEle.level+1));

            if (currEle.level == currLevel) {
                currLevelSum += currEle.node.val;
            } else {
                if (maximumLevelSum < currLevelSum) {
                    maxLevel = currLevel;
                    maximumLevelSum = currLevelSum;
                }
                currLevel = currEle.level;
                currLevelSum = currEle.node.val;
            }
        }
        if (queue.isEmpty()) { /* this is the last node we are processing */
            if (maximumLevelSum < currLevelSum) {
                maxLevel = currLevel;
                maximumLevelSum = currLevelSum;
            }
        }
        return maxLevel;
    }
}