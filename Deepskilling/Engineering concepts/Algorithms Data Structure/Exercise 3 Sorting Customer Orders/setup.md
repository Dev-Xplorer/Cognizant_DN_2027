## Project Configuration

Create the structural class file within your workspace to handle order attributes.

* Filename: `Order.java`

``` java
public class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalPrice() { return totalPrice; }

    @Override
    public String toString() {
        return String.format("Order [ID=%s, Customer=%s, Total Price=$Standardized]", 
                orderId, customerName, totalPrice);
    }
    
    // Quick helper for printing array details clearly
    @Override
    public String toString() {
        return "Order[ID=" + orderId + ", Name=" + customerName + ", Price=$" + totalPrice + "]";
    }
}
```