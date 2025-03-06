import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<String, Integer> inventory = new HashMap<>();
        HashMap<String, Double> prices = new HashMap<>();

        // Initial inventory setup
        inventory.put("Laptop", 10);
        inventory.put("Mouse", 50);
        inventory.put("Keyboard", 30);

        prices.put("Laptop", 1200.00);
        prices.put("Mouse", 25.50);
        prices.put("Keyboard", 50.75);

        while (true) {
            System.out.println("\nJohn Ray Inventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Set Quantity");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                input.next(); // Clear invalid input
                continue;
            }

            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = input.nextLine();

                    System.out.print("Enter item price: ");
                    if (!input.hasNextDouble()) {
                        System.out.println("Invalid price. Must be a number.");
                        input.next(); // Clear invalid input
                        continue;
                    }
                    double price = input.nextDouble();
                    if (price < 0) {
                        System.out.println("Price cannot be negative.");
                        continue;
                    }

                    System.out.print("Enter item quantity: ");
                    if (!input.hasNextInt()) {
                        System.out.println("Invalid quantity. Must be a number.");
                        input.next(); // Clear invalid input
                        continue;
                    }
                    int quantity = input.nextInt();
                    if (quantity < 0) {
                        System.out.println("Quantity cannot be negative.");
                        continue;
                    }

                    inventory.put(name, inventory.getOrDefault(name, 0) + quantity);
                    prices.put(name, price);
                    System.out.println("Item added successfully.");
                    break;

                case 2:
                    System.out.print("Enter item name: ");
                    String itemName = input.nextLine();

                    if (inventory.containsKey(itemName)) {
                        System.out.print("Enter new quantity: ");
                        if (!input.hasNextInt()) {
                            System.out.println("Invalid quantity. Must be a number.");
                            input.next(); // Clear invalid input
                            continue;
                        }
                        int newQuantity = input.nextInt();
                        if (newQuantity >= 0) {
                            inventory.put(itemName, newQuantity);
                            System.out.println("Quantity of " + itemName + " set to " + newQuantity);
                        } else {
                            System.out.println("Quantity cannot be negative.");
                        }
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 3:
                    System.out.printf("\n%-15s %-10s %-10s%n", "Item", "Price", "Quantity");
                    System.out.println("-----------------------------------------");
                    for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                        System.out.printf("%-15s $%-9.2f %-10d%n",
                                entry.getKey(), prices.get(entry.getKey()), entry.getValue());
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    input.close();
                    return; // Properly exits the program

                default:
                    System.out.println("Invalid choice, try again 😉");
            }
        }
    }
}
