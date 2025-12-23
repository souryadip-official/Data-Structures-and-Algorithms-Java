import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class BinaryTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public TreeNode root = null;
    private TreeNode createTree(Scanner sc) { //Time Complexity: O(n)
        System.out.print("Enter the data you want to insert (-1 for no node): ");
        int data = sc.nextInt();
        if(data == -1) return null;
        // Else, we have to create a new node
        TreeNode node = new TreeNode(data);
        System.out.println("Enter details for left child of node " + node.data + ": ");
        node.left = createTree(sc);
        System.out.println("Left subtree for node "+ node.data + " is created successfully!");
        System.out.println("Enter details for right child of node " + node.data + ": ");
        node.right = createTree(sc);
        System.out.println("Right subtree for node "+ node.data + " is created successfully!");
        return node;
    }
    public void initialise() { //Time Complexity: O(n)
        Scanner sc = new Scanner(System.in);
        this.root = createTree(sc);
        System.out.println("Tree is created successfully!");
        sc.close();
    }
    public void preorder(TreeNode root) { //Time Complexity: O(n)
        if(root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public void inorder(TreeNode root) { //Time Complexity: O(n)
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    public void postorder(TreeNode root) { //Time Complexity: O(n)
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
    public void levelOrderTop(TreeNode root) { //Time Complexity: O(n)
        // PYQ: Microsoft, Facebook, Adobe
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.add(root);
        queue.add(null); // Marker for the end of level
        /* This is just to print the tree in a level-order manner. We basically want a next-line after printing all the nodes in a level */
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node == null) {
                System.out.println(); // End of the current level
                if(queue.isEmpty()) break; // All levels are processed
                else queue.add(null); // Marker for the next level
            } else {
                System.out.print(node.data + " ");
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
    }
    public static void levelorderBottom_helper(TreeNode root, List<List<Integer>> list) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) q.add(root);
        else return;
        q.add(null);
        List<Integer> temp = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            if(node == null) {
                list.add(temp);
                temp = new ArrayList<>();
                if(q.isEmpty()) break;
                else q.add(null);
            } else {
                temp.add(node.data);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
    }
    public static List<List<Integer>> reverseListofLists(List<List<Integer>> list) {
        int limit = list.size()/2;
        int size = list.size();
        for(int i=0; i<limit; i++) {
            List<Integer> temp = list.get(i);
            list.set(i, list.get(size-1-i));
            list.set(size-1-i, temp);
        }
        return list;
    }
    public List<List<Integer>> levelOrderBottom() { //Time Complexity: O(n)
        // LeetCode Problem 107
        List<List<Integer>> list = new ArrayList<>();
        levelorderBottom_helper(this.root, list);
        return reverseListofLists(list);
    }
    public int countNodes(TreeNode root) { //Time Complexity: O(n)
        if(root == null) return 0;
        else {
            int noOfNodesInLeftSubtree = countNodes(root.left);
            int noOfNodesInRightSubtree = countNodes(root.right);
            return 1 + noOfNodesInLeftSubtree + noOfNodesInRightSubtree;
            /* Here adding 1 means the current node is counted */
        }
    }
    public int heightCalc(TreeNode root) { //Time Complexity: O(n)
        /* Note, here we are calculating height based on the number of nodes in the longest path from the route to the farthest leaf node */
        if(root == null) return 0;
        else {
            int heightOfLeftSubtree = heightCalc(root.left) + 1; /* Including the root itself */
            int heightOfRightSubtree = heightCalc(root.right) + 1; /* Including the root itself */
            return Math.max(heightOfLeftSubtree, heightOfRightSubtree);
        }
        /* If we want to calculate height in terms of number of edges in the longest path from the root to the farthest leaf node, we must write the following code. The reason behind this approach is that, in a tree, the number of edges is always equal to the number of nodes minus one (edges = nodes - 1), which is why when calculating the height in terms of nodes, we return 0 for a null node and add 1 at each level — but if we define height in terms of edges, we return -1 for a null node, since a single-node tree has 0 edges but 1 node. The code is as follows:
            if (root == null) return -1;
            return 1 + Math.max(heightInEdges(root.left), heightInEdges(root.right));
        */
    }
    public int calcNodeSum(TreeNode root) { //Time Complexity: O(n)
        if(root == null) return 0;
        else {
            int leftSubtreeSum = calcNodeSum(root.left);
            int rightSubtreeSum = calcNodeSum(root.right);
            return root.data + leftSubtreeSum + rightSubtreeSum;
        }
    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        else {
            int leftSubtreeDepth = minDepth(root.left);
            int rightSubtreeDepth = minDepth(root.right);
            if(leftSubtreeDepth == 0) return(rightSubtreeDepth + 1);
            else if(rightSubtreeDepth == 0) return(leftSubtreeDepth + 1);
            else return (Math.min(leftSubtreeDepth, rightSubtreeDepth) + 1);
        }
    }
    public int maxOf3_helper(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
    public int calcDiameter_Approach1(TreeNode root) { // Time Complexity: O(n^2)
        if(root == null) return 0;
        /* in case we have no node, we have no height and no diameter */
        else {
            int leftSubtreeHeight = heightCalc(root.left);
            int rightSubtreeHeight = heightCalc(root.right);
            int leftSubtreeDiameter = calcDiameter_Approach1(root.left);
            // in case the diameter exists in the left-subtree (the longest path lies entirely in the left subtree)
            int rightSubtreeDiameter = calcDiameter_Approach1(root.right);
            // in case the diameter exists in the right-subtree (the longest path lies entirely in the right subtree)
            int currNodeDiameter = leftSubtreeHeight + rightSubtreeHeight + 1;
            // in case the diameter involves the current node (the longest path goes through the current node)
            return maxOf3_helper(leftSubtreeDiameter, rightSubtreeDiameter, currNodeDiameter);
            /* Here adding 1 means the current node adds its own height */
        }
    }
    private static class TreeNodeInfo {
        int height;
        int diameter;
        TreeNodeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
    public TreeNodeInfo calcDiameter_helper(TreeNode root) { // Time Complexity: O(n)
        if(root == null) return (new TreeNodeInfo(0, 0));
        else {
            TreeNodeInfo leftSubtreeInfo = calcDiameter_helper(root.left);
            TreeNodeInfo rightSubtreeInfo = calcDiameter_helper(root.right);
            int currNodeHeight = Math.max(leftSubtreeInfo.height, rightSubtreeInfo.height) + 1;
            int diameterThroughCurrNode = leftSubtreeInfo.height + rightSubtreeInfo.height + 1;
            int currNodeDiameter = maxOf3_helper(leftSubtreeInfo.diameter, rightSubtreeInfo.diameter, diameterThroughCurrNode);
            return (new TreeNodeInfo(currNodeHeight, currNodeDiameter));
        }
    }
    public int calcDiameter_Approach2() {
        return calcDiameter_helper(this.root).diameter;
        /* Currently, we’re calculating diameter in terms of nodes on the path. If the problem asks for number of edges on the longest path, we need to subtract 1 at the end, and the code should be: return calcDiameter_helper(root).diameter - 1; This is because in a tree, number of edges involved = number of nodes involved - 1. */
    }
    public void preorder(TreeNode root, StringBuilder result) {
        if(root != null) {
            result.append('|').append(root.data).append('|');
            preorder(root.left, result);
            preorder(root.right, result);
        }
        else result.append('|').append('x').append('|');
        // x stands for NULL and | stands for starting and ending of one node data or null
    }
    /* Simplest approach: Time Complexity: O(n × m), Space Complexity: O(n + m) where n = Total number of nodes in the main tree (root) and m = Total number of nodes in the subtree (subRoot)*/
    public boolean checkSubtreeOrNot(TreeNode root, TreeNode subRoot) {
        // LeetCode Problem 572: All testcases passed
        // We need to check whether 'subroot' is a subtree of root
        StringBuilder preorderRoot = new StringBuilder();
        StringBuilder preorderSubroot = new StringBuilder();
        preorder(root, preorderRoot);
        preorder(subRoot, preorderSubroot);
        System.out.println(preorderRoot);
        System.out.println(preorderSubroot);
        return preorderRoot.toString().indexOf(preorderSubroot.toString()) != -1;
    }
    /* Approach 2: */
    private boolean isIdentical(TreeNode node, TreeNode subRoot) {
        if(node == null && subRoot == null) {
            /* All the nodes are checked. We can safely return true from here */
            return true;
        } else if(node == null || subRoot == null || node.data != subRoot.data) {
            /* These conditions are valid when one of the main tree node or the subroot node are exhausted we still had nodes to check. Hence it cannot be a subtree. On the other hand, if the data fails to match, then also it is not a subtree */
            return false;
        }
        /* Check for the opinion of the left subtree */
        if(!isIdentical(node.left, subRoot.left)) {
            /* This means that the left subtree told that it is not a subtree */
            return false;
        }
        /* Check for the opinion of the right subtree */
        if(!isIdentical(node.right, subRoot.right)) {
            /* This means that the right subtree told that it is not a subtree */
            return false;
        }
        /* If it passes all the above conditions, then it is definitely a subtree */
        return true;
    }
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if(root == null) return false;
        /* Check for the current node */
        if(root.data == subroot.data) {
            if(isIdentical(root, subroot))
                return true;
        }
        /* Check for the existence of the subtree in the left and right subtrees */
        return isIdentical(root.left, subroot) || isIdentical(root.right, subroot);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.data == t2.data)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }
    /* To check whether a two tree is same or not: LeetCode Problem 100 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if(p == null || q == null) return false;
        else return p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    /* To check whether a tree is symmetric or not: LeetCode Problem 101 */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    /* LeetCode Problem 103: Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between). For example, root = [3,9,20,null,null,15,7], Output: [[3],[20,9],[15,7]] */
    public static void levelorder(TreeNode root, List<List<Integer>> list) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) q.add(root);
        else return;
        q.add(null);
        List<Integer> temp = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            if(node == null) {
                list.add(temp);
                temp = new ArrayList<>();
                if(q.isEmpty()) break;
                else q.add(null);
            } else {
                temp.add(node.data);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
    }
    public static List<List<Integer>> reverse(List<List<Integer>> list) {
        int limit = list.size()/2;
        int size = list.size();
        for(int i=0; i<size; i++) {
            if(i % 2 == 1) {
                // reversing the lists which are at odd indices
                List<Integer> temp = list.get(i);
                for(int j=0; j<temp.size()/2; j++) {
                    int val = temp.get(j);
                    temp.set(j, temp.get(temp.size()-1-j));
                    temp.set(temp.size()-1-j, val);
                }
            }
        }
        return list;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelorder(root, list);
        return reverse(list);
    }

    private static class TreeNodeInfo2 {
        TreeNode node;
        int hd; // horizontal distance
        TreeNodeInfo2(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public void topView(TreeNode root) {
        Queue<TreeNodeInfo2> q = new LinkedList<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        int minHd = Integer.MAX_VALUE, maxHd = Integer.MIN_VALUE; // minimum and maximum horizontal distances
        q.add(new TreeNodeInfo2(root, 0));
        q.add(null); // to track the current level
        while(!q.isEmpty()) {
            TreeNodeInfo2 info = q.remove();
            if(info == null) {
                if(q.isEmpty()) break;
                else q.add(null); // for the next levels
            } else {
                if(map.get(info.hd) == null) {
                    // this means no other node with existing hd already exists
                    map.put(info.hd, info.node);
                }
                if(info.node.left != null) {
                    q.add(new TreeNodeInfo2(info.node.left, info.hd-1));
                    minHd = Math.min(minHd, info.hd-1);
                    // we won't perform max check here because a left child only reduces hd
                }
                if(info.node.right != null) {
                    q.add(new TreeNodeInfo2(info.node.right, info.hd+1));
                    maxHd = Math.max(maxHd, info.hd+1);
                    // we won't perform min check here because a right child only increases hd
                }
            }
        }
        // we need to print the top view now
        for(int i=minHd; i<=maxHd; i++)
            System.out.print(map.get(i).data + " ");
        System.out.println();
    }
    public void kthLevelOfTree(TreeNode root, int currLevel, int k) {
        if(root != null) {
            if(currLevel == k) {
                System.out.print(root.data + " ");
                return;
            }
            kthLevelOfTree(root.left, currLevel+1, k);
            kthLevelOfTree(root.right, currLevel+1, k);
        }
    }
    public boolean getPath(TreeNode node, int n, ArrayList<TreeNode> path) {
        if(node == null) return false;
        path.add(node);
        if(node.data == n) return true;
        boolean leftResult = getPath(node.left, n, path);
        boolean rightResult = getPath(node.right, n, path);
        if(leftResult || rightResult) return true;
        path.remove(path.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, int n1, int n2) { // Time Complexity = O(n) = Space Complexity
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        int i = 0;
        for(; i<path1.size() && i < path2.size(); i++) {
            if(path1.get(i) != path2.get(i))
                break;
        }
        return path1.get(i-1);
    }
    public TreeNode lowestCommonAncestorV2(TreeNode root, int n1, int n2) { // Time Complexity: O(n), Space Complexity: O(1) {Without the Recursion Stack}
        if(root == null || root.data == n1 || root.data == n2) return root;
        TreeNode leftResult = lowestCommonAncestorV2(root.left, n1, n2);
        TreeNode rightResult = lowestCommonAncestorV2(root.right, n1, n2);
        if(leftResult == null) return rightResult;
        else if(rightResult == null) return leftResult;
        else return root;
    }
    public int lcaDist(TreeNode node, int n) {
        if(node == null) return -1;
        else if(root.data == n) return 0;
        int leftDist = lcaDist(node.left, n);
        int rightDist = lcaDist(node.right, n);
        if(leftDist == -1 && rightDist == -1) return -1;
        else if(leftDist == -1) return rightDist+1;
        else return leftDist+1;
    }
    public int minimumDistance(TreeNode root, int n1, int n2) {
        TreeNode lca = lowestCommonAncestorV2(root, n1, n2);
        int lcaDist1 = lcaDist(root, n1);
        int lcaDist2 = lcaDist(root, n2);
        return lcaDist1 + lcaDist2;
    }
    public int KAncestor(TreeNode root, int n, int k) {
        if(root == null) return -1;
        else if(root.data == n) return 0;
        int leftDistance = KAncestor(root.left, n, k);
        int rightDistance = KAncestor(root.right, n, k);
        if(leftDistance == -1 && rightDistance == -1) return -1;
        int greaterVal = Math.max(leftDistance, rightDistance);
        if(greaterVal + 1 == k)
            // then this node is my kth ancestor
            System.out.print(root.data + " ");
        return greaterVal + 1;
    }
    public int convertToSumTree(TreeNode root) { // Time Complexity: O(n)
        if(root == null) return 0;
        int leftSubtreeSum = convertToSumTree(root.left);
        int rightSubtreeSum = convertToSumTree(root.right);
        int currNodeValue = root.data;
        root.data = leftSubtreeSum + rightSubtreeSum;
        return currNodeValue + root.data;
    }
}
public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.initialise();
        System.out.print("Pre-order traversal: ");
        tree.preorder(tree.root);
        System.out.println();
        System.out.print("In-order traversal: ");
        tree.inorder(tree.root);
        System.out.println();
        System.out.print("Post-order traversal: ");
        tree.postorder(tree.root);
        System.out.println();
        System.out.println("Level-order traversal (from top): ");
        tree.levelOrderTop(tree.root);
        System.out.println("Level-order traversal (from bottom): " + tree.levelOrderBottom());
        System.out.println("Total nodes in the tree: " + tree.countNodes(tree.root));
        System.out.println("Total node sum: " + tree.calcNodeSum(tree.root));
        System.out.println("Height of the tree is: " + tree.heightCalc(tree.root)); /* Maximum depth */
        System.out.println("Minimum depth of the tree is: " + tree.minDepth(tree.root)); /* Minimum depth */
        System.out.println("Diameter of the tree (Version 1) is: " + tree.calcDiameter_Approach1(tree.root));
        System.out.println("Diameter of the tree (Version 2) is: " + tree.calcDiameter_Approach2());
        System.out.print("Top view of the tree from left to right is: ");
        tree.topView(tree.root);
        System.out.print("Kth level of tree: ");
        tree.kthLevelOfTree(tree.root, 1, 2);
        System.out.println("\nLowest common ancestor result: " + tree.lowestCommonAncestor(tree.root, 4, 7).data);
        int totalSum = tree.convertToSumTree(tree.root);
        System.out.println("Total sum of the tree is: " + totalSum);
        tree.levelOrderTop(tree.root);
    }
}
