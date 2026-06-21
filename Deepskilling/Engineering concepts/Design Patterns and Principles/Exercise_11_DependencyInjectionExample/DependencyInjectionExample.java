// 1. The Dependency Interface
interface CustomerRepository {
    String findCustomerById(String id);
}

// 2. The Concrete Dependency
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        if (id.equals("1001")) {
            return "Alice Smith";
        } else if (id.equals("1002")) {
            return "Bob Johnson";
        }
        return "Unknown Customer";
    }
}

// 3. The Dependent Class (The Worker)
class CustomerService {
    
    private final CustomerRepository customerRepository;

    // CONSTRUCTOR INJECTION
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Business Logic Method
    public void printCustomerDetails(String customerId) {
        System.out.println("Fetching data for ID: " + customerId + "...");
        String customerName = customerRepository.findCustomerById(customerId);
        System.out.println("Result: " + customerName + "\n");
    }
}
// 4. The Test Class 
public class DependencyInjectionExample {
    public static void main(String[] args) {
        
        System.out.println("--- Booting up Application ---");
        
        CustomerRepository myDatabase = new CustomerRepositoryImpl();
        
        CustomerService customerService = new CustomerService(myDatabase);
        
        System.out.println("--- Executing Business Logic ---");
        customerService.printCustomerDetails("1001");
        customerService.printCustomerDetails("9999");
    }
}