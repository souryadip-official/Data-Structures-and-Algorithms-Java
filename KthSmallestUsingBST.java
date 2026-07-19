import java.util.*;
public class Main {
	public static class Node {
		int val;
		Node left, right;
		public Node(int v) {
			this.val = v;
			this.left = this.right = null;
		}
	}
	public static void construct(Node root, Node nn) {
		if (root == null) {
			return;
		}

		if (nn.val < root.val) {
			if (root.left == null) {
				root.left = nn;
				return;
			}
			construct(root.left, nn);
		}

		if (nn.val > root.val) {
			if (root.right == null) {
				root.right = nn;
				return;
			}
			construct(root.right, nn);
		}
	}
	public static void inorder(Node root, ArrayList<Integer> inord) {
		if (root != null) {
			inorder(root.left, inord);
			inord.add(root.val);
			inorder(root.right, inord);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of nodes: ");
		int n = sc.nextInt();


		System.out.print("Enter the elements: ");
		sc.nextLine();
		String elements = sc.nextLine();
		String[] eles = elements.trim().split(" ");
		int[] arr = new int[eles.length];
		for (int i=0; i<eles.length; i++) {
			arr[i] = Integer.parseInt(eles[i].trim());
		}


		System.out.print("Enter value of k: ");
		int k = sc.nextInt();
		if (k <= 0 || k > arr.length) {
		    System.out.println("Invalid Input");
		    System.exit(0);
		}

		System.out.println(Arrays.toString(arr));

		Node root = null;
		for (int i=0; i<arr.length; i++) {
			if (root == null) {
				root = new Node(arr[i]);
			} else {
				construct(root, new Node(arr[i]));
			}
		}

		ArrayList<Integer> inord = new ArrayList<>();
		inorder(root, inord);
		System.out.print(inord.get(k-1));
	}
}
