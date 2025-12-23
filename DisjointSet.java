import java.util.Scanner;
public class DisjointSet {
    public static void display(int[] parent, int[] rank) {
        System.out.println("========== Parent ==========");
        for (int ele: parent) System.out.print(ele + " ");
        System.out.println("\n========== Rank ==========");
        for (int ele: rank) System.out.print(ele + " ");
    }
    public static int find(int element, int[] parent) {
        // Rank is only updated during union, never during find.
        if (element == parent[element]) return element; // If the parent of the element is itself, then it is the supreme parent
        else {
            parent[element] = find(parent[element], parent); // Path compression for faster performance
            return parent[element];
        }
    }
    public static void union(int a, int b, int[] parent, int[] rank) {
        int root_for_a = find(a, parent);
        int root_for_b = find(b, parent);
        if (root_for_a != root_for_b) {
            if (rank[root_for_a] > rank[root_for_b]) {
                /* root_for_a is of higher rank compared to root_for_b. Hence, attaching root_for_b to root root_for_a is not going to change the rank for root_for_a */
                parent[root_for_b] = root_for_a;
            }
            else if (rank[root_for_b] > rank[root_for_a]) {
                /* root_for_b is of higher rank compared to root_for_a. Hence, attaching root_for_a to root root_for_b is not going to change the rank for root_for_b */
                parent[root_for_a] = root_for_b;
            }
            else {
                /* Both have the same rank. Since both of them have the same rank, hence we can attach anyone to the other. Also, in this scenario, attaching root_for_b to root_for_a increases the rank of root_for_a by 1 and vice versa */
                int random_choice = (int) Math.round(Math.random());
                if (random_choice == 0) {
                    parent[root_for_a] = root_for_b;
                    rank[root_for_b]++;
                } else {
                    parent[root_for_b] = root_for_a;
                    rank[root_for_a]++;
                }
                /* This is done to ensure randomness and no biasing */
            }
        }
        // If both have the same parent, then it will create a cycle in the disjoint set which completely breaks the disjoint set hence skipped.
    }
    public static void operations(int n, Scanner sc) {
        boolean cont = true;
        int[] rank = new int[n]; // Tracks the rank of each element in the data structure
        int[] parent = new int[n]; // Tracks the parent of each element in the data structure
        for (int i=0; i<n; i++) parent[i] = i; // Initially, all are their own parent
        while(cont) {
            System.out.print("========== MENU ==========\n1 ---> Find \n2 ---> Union\nEnter your choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("You opted for Find(x)\nEnter x: ");
                    int x = sc.nextInt();
                    if (x<0 || x>=n) {
                        System.out.println("Invalid input!");
                        break;
                    }
                    System.out.println("Find(" + x + ") = " + find(x, parent));
                    break;
                case 2:
                    System.out.print("You opted for Union(a,b)\nEnter a: ");
                    int a = sc.nextInt();
                    System.out.print("Enter b: ");
                    int b = sc.nextInt();
                    if ((a<0 || a >= n) || (b<0 || b>=n)) {
                        System.out.println("Invalid input!");
                        break;
                    }
                    union(a, b, parent, rank);
                    System.out.println("Union(" + a + "," + b + ") is successfully done!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            display(parent, rank);
            System.out.print("\nDo you still want to continue? (0 for NO | 1 for YES) ---> ");
            ch = sc.nextInt();
            cont = (ch != 0);
        }
        System.out.print("========== Thank you ==========");
    }
    public static void main(String[] args) {
        // First, we need to take the input of number of elements
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        operations(n, sc);
    }
}
