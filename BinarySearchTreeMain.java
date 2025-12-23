import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class BST {
    static class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;
        BSTNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public BSTNode root = null;
    private BSTNode insert(BSTNode root, BSTNode newNode) { // Time Complexity: O(h)
        if (root == null) return newNode;
        if(root.data == newNode.data) {
            System.out.print("BST should not have duplicate keys.");
            return root;
        }
        if(newNode.data < root.data) root.left = insert(root.left, newNode);
        else root.right = insert(root.right, newNode);
        return root;
    }
    public void createTree() { // Time Complexity: O(n * h)
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the data you want to insert (-1 to stop): ");
        int data = sc.nextInt();
        if(data == -1) return;
        this.root = insert(this.root, new BSTNode(data));
        System.out.println(data + " is inserted successfully!");
        createTree();
    }
    public void inorder(BSTNode root) { // Time Complexity: O(n)
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    public boolean search(BSTNode root, int key) { // Time Complexity: O(h)
        if(root == null) return false;
        if(root.data == key) return true;
        if(key < root.data) return search(root.left, key);
        else return search(root.right, key);
    }
    private BSTNode getInorderSuccessor(BSTNode root) {
        while(root.left != null) root = root.left;
        return root;
    }
    public void printInRange(BSTNode root, int k1, int k2) {
        if(root == null) return;
        if(k1 <= root.data && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if(root.data < k1) printInRange(root.right, k1, k2);
        else printInRange(root.left, k1, k2);
    }
    public void printPath(BSTNode root, ArrayList<Integer> path) {
        if(root == null) return;
        path.add(root.data);
        if(root.left == null && root.right == null)
            System.out.println(path);
        else {
            printPath(root.left, path);
            printPath(root.right, path);
        }
        path.remove(path.size()-1);
    }
    private BSTNode delete(BSTNode root, int data) { // Time Complexity: O(h)
        if(data > root.data) root.right = delete(root.right, data);
        else if(data < root.data) root.left = delete(root.left, data);
        else {
            // checking for the case when the node to be deleted is a leaf node
            if(root.left == null && root.right == null) return null;
            // checking for the case when the node to be deleted is non-null and has only one child
            else if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            // checking for the case when the node to be deleted is non-null and has two child
            else {
                BSTNode inorderSuccessor = getInorderSuccessor(root.right);
                root.data = inorderSuccessor.data;
                root.right = delete(root.right, inorderSuccessor.data);
            }
        }
        return root;
    }
    public boolean deleteNode(int data) {
        if(!search(root, data)) return false;
        else {
            this.root = delete(this.root, data);
            return true;
        }
    }
    public boolean validateBST(BSTNode root, BSTNode min, BSTNode max) {
        if(root == null) return true;
        else if(min != null && root.data <= min.data) return false;
        else if(max != null && root.data >= max.data) return false;
        else return validateBST(root.left, min, root) && validateBST(root.right, root, max);
    }
    public BSTNode getMirror(BSTNode root) { // Time Complexity: O(n),Space Complexity: O(h)
        if(root == null) return null;
        BSTNode leftSubtreeMirror = getMirror(root.left);
        BSTNode rightSubtreeMirror = getMirror(root.right);
        root.left = rightSubtreeMirror;
        root.right = leftSubtreeMirror;
        return root;
    }
    public BSTNode getBalancedBST(ArrayList<Integer> arr, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start)/2;
        BSTNode root = new BSTNode(arr.get(mid));
        root.left = getBalancedBST(arr, start, mid-1);
        root.right = getBalancedBST(arr, mid+1, end);
        return root;
    }
    public void getInorderSequence(BSTNode root, ArrayList<Integer> nodes) {
        if(root != null) {
            getInorderSequence(root.left, nodes);
            nodes.add(root.data);
            getInorderSequence(root.right, nodes);
        }
    }
    static class NodeInfo {
        boolean isValidBST;
        int size, min, max;
        NodeInfo(boolean isValidBST, int size, int min, int max) {
            this.isValidBST = isValidBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxBSTSize = 0;
    public NodeInfo getLargestBST(BSTNode root) {
        if(root == null)
            return new NodeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        NodeInfo leftSubtreeInfo = getLargestBST(root.left);
        NodeInfo rightSubtreeInfo = getLargestBST(root.right);

        int currNodeSize = leftSubtreeInfo.size + rightSubtreeInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftSubtreeInfo.min, rightSubtreeInfo.min));
        int max = Math.max(root.data, Math.max(leftSubtreeInfo.max, rightSubtreeInfo.max));

        boolean isCurrValidBST;
        if(root.data <= leftSubtreeInfo.max || root.data >= rightSubtreeInfo.min)
            return new NodeInfo(false, currNodeSize, min, max);
        if(leftSubtreeInfo.isValidBST && rightSubtreeInfo.isValidBST) {
            maxBSTSize = Math.max(maxBSTSize, currNodeSize);
            return new NodeInfo(true, currNodeSize, min, max);
        }
        return new NodeInfo(false, currNodeSize, min, max);
    }
    private ArrayList<Integer> merge(ArrayList<Integer> seq1, ArrayList<Integer> seq2) { // Time Complexity: O(m+n)
        ArrayList<Integer> mergedList = new ArrayList<>();
        int i=0, j=0;
        while(i < seq1.size() && j < seq2.size()) {
            if(seq1.get(i) < seq2.get(j)) {
                mergedList.add(seq1.get(i));
                i++;
            } else {
                mergedList.add(seq2.get(j));
                j++;
            }
        }
        while(i < seq1.size()) {
            mergedList.add(seq1.get(i));
            i++;
        }
        while(j < seq2.size()) {
            mergedList.add(seq2.get(j));
            j++;
        }
        return mergedList;
    }
    public BSTNode mergeBST(BSTNode root1, BSTNode root2) {
        if(root1 == null && root2 == null) return null;
        if(root1 == null) return root2;
        else if(root2 == null) return root1;
        else {
            ArrayList<Integer> seq1 = new ArrayList<>();
            ArrayList<Integer> seq2 = new ArrayList<>();
            getInorderSequence(root1, seq1);
            getInorderSequence(root2, seq2);

            ArrayList<Integer> finalMergedSeq = merge(seq1, seq2);
            return getBalancedBST(finalMergedSeq, 0, finalMergedSeq.size()-1);
        }
    }
}
public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.createTree();
        tree.inorder(tree.root);
        System.out.println("Is the tree a valid BST? " + tree.validateBST(tree.root, null, null));
        BST mirrorTree = new BST();
        mirrorTree.root = tree.getMirror(tree.root);
        mirrorTree.inorder(mirrorTree.root);
        // Converting to a balanced BST from a sorted array
        ArrayList<Integer> nodes = new ArrayList<>(Arrays.asList(3,5,6,8,10,11,12));
        tree.root = tree.getBalancedBST(nodes, 0, nodes.size()-1);
        // Converting an existing BST to a balanced BST -> Time Complexity: O(n)
        ArrayList<Integer> inorderSequence = new ArrayList<>();
        tree.getInorderSequence(tree.root, inorderSequence);
        tree.root = tree.getBalancedBST(inorderSequence, 0, inorderSequence.size()-1);
        tree.getLargestBST(tree.root);
        System.out.println("Largest BST: " + BST.maxBSTSize);
    }
}
