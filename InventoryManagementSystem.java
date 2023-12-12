import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

public class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(String name, double price, int quantity) {
        inventory.put(name, new Product(name, price, quantity));
        System.out.println("Product added successfully!");
    }

    public void updateProduct(String name, double price, int quantity) {
        if (inventory.containsKey(name)) {
            Product product = inventory.get(name);
            product.price = price;
            product.quantity = quantity;
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    public void removeProduct(String name) {
        if (inventory.containsKey(name)) {
            inventory.remove(name);
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Product product : inventory.values()) {
            System.out.println("Name: " + product.name + ", Price: $" + product.price + ", Quantity: " + product.quantity);
        }
    }

    public void recordSale(String name, int quantitySold) {
        if (inventory.containsKey(name)) {
            Product product = inventory.get(name);
            if (product.quantity >= quantitySold) {
                product.quantity -= quantitySold;
                System.out.println("Sale recorded successfully!");
            } else {
                System.out.println("Not enough stock for the sale!");
            }
        } else {
            System.out.println("Product not found!");
        }
    }

    public void generateReport() {
        System.out.println("Sales Report:");
        for (Product product : inventory.values()) {
            System.out.println("Name: " + product.name + ", Quantity Sold: " + (product.quantity - product.quantity));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagementSystem inventorySystem = new InventoryManagementSystem();

        while (true) {
            System.out.println("\nInventory Management System Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Record Sale");
            System.out.println("6. Generate Report");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter product price: $");
                    double productPrice = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int productQuantity = scanner.nextInt();
                    inventorySystem.addProduct(productName, productPrice, productQuantity);
                    break;

                case 2:
                    System.out.print("Enter product name to update: ");
                    String updateProductName = scanner.next();
                    System.out.print("Enter new product price: $");
                    double updateProductPrice = scanner.nextDouble();
                    System.out.print("Enter new product quantity: ");
                    int updateProductQuantity = scanner.nextInt();
                    inventorySystem.updateProduct(updateProductName, updateProductPrice, updateProductQuantity);
                    break;

                case 3:
                    System.out.print("Enter product name to remove: ");
                    String removeProductName = scanner.next();
                    inventorySystem.removeProduct(removeProductName);
                    break;

                case 4:
                    inventorySystem.displayInventory();
                    break;

                case 5:
                    System.out.print("Enter product name for sale: ");
                    String saleProductName = scanner.next();
                    System.out.print("Enter quantity sold: ");
                    int quantitySold = scanner.nextInt();
                    inventorySystem.recordSale(saleProductName, quantitySold);
                    break;

                case 6:
                    inventorySystem.generateReport();
                    break;

                case 7:
                    System.out.println("Exiting Inventory Management System. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
