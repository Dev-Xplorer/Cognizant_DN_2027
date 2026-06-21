public class Main {
    public static void main(String[] args) {
        InventoryManager inventor1 = new InventoryManager();


        Product p1 = new Product("P001", "toy car", 10,999.99);
        Product p2 = new Product("P002", "cold drink", 100,250f);

        inventor1.addProduct(p1);
        inventor1.addProduct(p1);
        inventor1.addProduct(p2);

        System.out.println("\n--- Current Inventory ---");
        inventor1.displayInventory();

        System.out.println("\n--- Updating Laptop ---");
        inventor1.updateProduct("P001", 8, 849.99);

        System.out.println("\n--- Deleting Smartphone ---");
        inventor1.deleteProduct("P002");

        System.out.println("\n--- Final Inventory ---");
        inventor1.displayInventory();

    }
}
