import java.util.Scanner;
import java.util.HashMap;
public class HashMap01 {
    public static Scanner sc = new Scanner(System.in);
    public static void add(HashMap<String, Integer> hashmap) {
        System.out.print("Enter food item to add: ");
        String item_to_add = sc.nextLine().toUpperCase();
        System.out.print("Enter price of the item: ");
        int price = sc.nextInt();
        sc.nextLine(); /* to consume the newline left by nextInt */
        if (hashmap.containsKey(item_to_add)) /* to check the existence of a key in a hashmap */
            System.out.println("A data with the same key is already stored!");
        else {
            hashmap.put(item_to_add, price);
            System.out.println("Data successfully added!");
        }
    }

    public static void delete(HashMap<String, Integer> hashmap) {
        System.out.print("Enter food item to delete: ");
        String item_to_delete = sc.nextLine().toUpperCase();
        if (!hashmap.containsKey(item_to_delete))
            System.out.println("No data is stored for the given item!");
        else {
            hashmap.remove(item_to_delete);
            System.out.println("Data successfully deleted!");
        }
    }

    public static void search(HashMap<String, Integer> hashmap) {
        System.out.print("Enter food item to search: ");
        String item_to_search = sc.nextLine().toUpperCase();
        if (!hashmap.containsKey(item_to_search))
            System.out.println("No data is stored for the given item!");
        else
            System.out.println("Data found: (" + item_to_search + ", " + hashmap.get(item_to_search) + ")");
    }

    public static void fetchPrice(HashMap<String, Integer> hashmap) {
        System.out.print("Enter food item to get its price: ");
        String item_to_fetch_price = sc.nextLine().toUpperCase();
        if (!hashmap.containsKey(item_to_fetch_price))
            System.out.println("No data is stored for the given item!");
        else
            System.out.println("Price fetched: " + hashmap.get(item_to_fetch_price));
    }

    public static void update(HashMap<String, Integer> hashmap) {
        System.out.print("Enter food item to whose price you want to update: ");
        String item_to_update_price = sc.nextLine().toUpperCase();
        if (!hashmap.containsKey(item_to_update_price))
            System.out.println("No data is stored for the given item!");
        else {
            System.out.print("Enter new price of " + item_to_update_price + ": ");
            int newPrice = sc.nextInt();
            sc.nextLine(); /* to consume the left-over newline */
            hashmap.replace(item_to_update_price, newPrice);
            System.out.println("Price updated for " + item_to_update_price + ". New Price set to " + newPrice + ".");
        }
    }

    public static void printLine() {
        for (int i=1; i<=21; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void display(HashMap<String, Integer> hashmap) {
        System.out.println("Food Item\t\tPrice");
        if (hashmap.isEmpty())
            System.out.println("---- NO DATA ITEM ----");
        else {
            printLine();
            for (String key : hashmap.keySet()) {
                System.out.println(key + " \t\t\t " + hashmap.get(key));
                printLine();
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashmap = new HashMap<>(); /* To store (String, Integer) key-value (food, price) pairs */
        while (true) {
            System.out.print("\nWelcome to Canteen Data Management\n1---> Add new item\n2---> Delete an item\n3---> Search for an item\n4---> Get price for an item\n5---> Update price for an item\n6---> Display data\n7---> Exit\nEnter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); /* to consume the left-over newline */
            switch (ch) {
                case 1: add(hashmap); break;
                case 2: delete(hashmap); break;
                case 3: search(hashmap); break;
                case 4: fetchPrice(hashmap); break;
                case 5: update(hashmap); break;
                case 6: display(hashmap); break;
                case 7:
                    System.out.println("========== Thank you ==========");
                    return; /* or, we could have also used System.exit(0) */
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
