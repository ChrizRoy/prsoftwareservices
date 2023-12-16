import java.util.*;

public class InventoryManagement {
    private static final Map<String, Product> inventory = new HashMap<>();
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Sell Product");
            System.out.println("5. Generate Reports");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    sellProduct();
                    break;
                case 5:
                    generateReports();
                    break;
                case 6:
                    System.out.println("Exiting the program. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product ID: ");
        String productId = sc.nextLine();

        if (inventory.containsKey(productId)) {
            System.out.println("Product with ID " + productId + " already exists.");
        } else {
            System.out.print("Enter product name: ");
            String productName = sc.nextLine();
            System.out.print("Enter initial stock quantity: ");
            int initialStock = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            Product newProduct = new Product(productName, initialStock);
            inventory.put(productId, newProduct);
            System.out.println("Product added successfully.");
        }
    }

    private static void updateProduct() {
        System.out.print("Enter product ID to update: ");
        String productId = sc.nextLine();

        if (inventory.containsKey(productId)) {
            System.out.print("Enter new stock quantity: ");
            int newStock = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            Product product = inventory.get(productId);
            product.setStockQuantity(newStock);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    private static void removeProduct() {
        System.out.print("Enter product ID to remove: ");
        String productId = sc.nextLine();

        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    private static void sellProduct() {
        System.out.print("Enter product ID to sell: ");
        String productId = sc.nextLine();

        if (inventory.containsKey(productId)) {
            Product product = inventory.get(productId);

            System.out.print("Enter quantity to sell: ");
            int quantitySold = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            if (product.sell(quantitySold)) {
                System.out.println("Sale recorded successfully.");
            } else {
                System.out.println("Insufficient stock. Sale not recorded.");
            }
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    private static void generateReports() {
        System.out.println("Product Reports:");
        for (Map.Entry<String, Product> entry : inventory.entrySet()) {
            System.out.println("Product ID: " + entry.getKey());
            System.out.println("Product Name: " + entry.getValue().getProductName());
            System.out.println("Stock Quantity: " + entry.getValue().getStockQuantity());
            System.out.println("----------------------");
        }
    }

    private static class Product {
        private String productName;
        private int stockQuantity;

        public Product(String productName, int stockQuantity) {
            this.productName = productName;
            this.stockQuantity = stockQuantity;
        }

        public String getProductName() {
            return productName;
        }

        public int getStockQuantity() {
            return stockQuantity;
        }

        public void setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
        }

        public boolean sell(int quantitySold) {
            if (quantitySold <= stockQuantity) {
                stockQuantity -= quantitySold;
                return true;
            } else {
                return false;
            }
        }
    }
}
