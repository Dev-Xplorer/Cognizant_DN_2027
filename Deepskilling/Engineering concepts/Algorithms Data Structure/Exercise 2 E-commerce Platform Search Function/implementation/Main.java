import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("P001", "Laptop", "Electronics");
        products[1] = new Product("P002", "Smartphone", "Electronics");
        products[2] = new Product("P003", "Headphones", "Electronics");
        products[3] = new Product("P004", "Shoes", "Fashion");
        products[4] = new Product("P005", "T-shirt", "Fashion");

        String targetProductName = "Smartphone";
        // Linear Search - O(n)
        Product foundProductLinear = EcommerceSearch.linearSearchProduct(products, targetProductName);
        if (foundProductLinear != null) {
            System.out.println("Linear Search: Found product - " + foundProductLinear);
        } else {
            System.out.println("Linear Search: Product not found.");
        }

        // Binary Search - O(log n) - requires sorted array
        Arrays.sort(products , (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));
        Product foundProductBinary = EcommerceSearch.binarySearchProduct(products, targetProductName);

        if (foundProductBinary != null) {
            System.out.println("Binary Search: Found product - " + foundProductBinary);
        } else {
            System.out.println("Binary Search: Product not found.");
        }
    }    
}
