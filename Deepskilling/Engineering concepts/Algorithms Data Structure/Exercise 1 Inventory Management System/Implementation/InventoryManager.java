import java.util.HashMap;
import java.util.Map;
// import java.util.HashMap;

public class InventoryManager {
    private Map<String , Product> invantory;

    public InventoryManager (){
        invantory = new HashMap<>();
    }
    public void addProduct(Product product){
        if (invantory.putIfAbsent(product.getProductId(), product) != null){
            System.out.println("Product already present");
        }
        else{
            System.out.println("Product added successfully");
        }
    }
    public void updateProduct(String productId , int quantity , double price){
        Product product = invantory.get(productId);
        if (product != null ){
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("product updated successfully");
        }
        else{
            System.out.println("product not exist");
        }
    }
    public void deleteProduct(String productId){
        Product product = invantory.remove(productId);
        if (product != null){
            System.out.println("product delete successfully");
            System.out.println("deleted procuct" + product.getProductDetail());
        }
        else{
            System.out.println("product not exist");
        }
    }
    public void displayInventory(){
        if(!invantory.isEmpty()){
            for (Product product : invantory.values()){
                System.out.println(product.getProductDetail());
            }
        }
        else{
            System.out.println("inventor is empty");
        }
    }


}
