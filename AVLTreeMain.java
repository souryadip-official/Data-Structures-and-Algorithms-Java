class AVL {
    static class AVLNode {
        int data, balancingFactor;
        AVLNode left;
        AVLNode right;
        AVLNode(int data) {
            this.data = data;
            this.balancingFactor = 0;
            this.left = null;
            this.right = null;
        }
    }
    // Code is not usually asked in exam, if you want to go through, go to /:E/Java DSA/BST/AVL.pdf (not the exact path, but still enough explanatory
}
public class AVLTreeMain {
    public static void main(String[] args) {
        AVL tree = new AVL();
    }
}
