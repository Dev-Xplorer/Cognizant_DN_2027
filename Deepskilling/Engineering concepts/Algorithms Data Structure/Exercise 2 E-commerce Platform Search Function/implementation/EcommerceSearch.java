public class EcommerceSearch {

    public static Product linearSearchProduct(Product[] products, String targetProductName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetProductName)) {
                return product;
            }
        }
        return null;
    }
    public static Product binarySearchProduct(Product[] products, String targetProductName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = products[mid];

            if (midProduct.getProductName().equalsIgnoreCase(targetProductName)) {
                return midProduct;
            } else if (midProduct.getProductName().compareToIgnoreCase(targetProductName) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}