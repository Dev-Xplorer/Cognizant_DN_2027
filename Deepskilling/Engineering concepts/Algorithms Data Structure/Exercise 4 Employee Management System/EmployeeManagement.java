public class EmployeeManagement {
    private Employee[] employees;
    private int count;

    public EmployeeManagement(int capacity) {
        this.employees = new Employee[capacity];
        this.count = 0;
    }

    public boolean addEmployee(Employee employee) {
        if (count >= employees.length) {
            return false;
        }
        employees[count] = employee;
        count++;
        return true;
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(String employeeId) {
        int targetIndex = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex == -1) {
            return false;
        }

        for (int i = targetIndex; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        
        employees[count - 1] = null;
        count--;
        return true;
    }
}