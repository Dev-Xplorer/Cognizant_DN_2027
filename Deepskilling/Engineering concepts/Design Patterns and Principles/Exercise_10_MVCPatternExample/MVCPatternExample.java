// 1. Model Class
// A pure Java POJO representing the data structure
class Student {
    private String id;
    private String name;
    private String grade;

    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

// 2. Singleton Mock Database (Bonus Requirement)
// Simulates a backend repository that only has one instance in memory
class StudentDatabase {
    private static StudentDatabase instance;

    private StudentDatabase() {}

    public static StudentDatabase getInstance() {
        if (instance == null) {
            instance = new StudentDatabase();
        }
        return instance;
    }

    // Simulating fetching a student from a real database
    public Student fetchStudent() {
        return new Student("CS-101", "Aarav", "B+");
    }
}

// 3. View Class
// Responsible ONLY for rendering the data to the screen
class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("--- Student Record ---");
        System.out.println("Name:  " + studentName);
        System.out.println("ID:    " + studentId);
        System.out.println("Grade: " + studentGrade);
        System.out.println("----------------------\n");
    }
}

// 4. Controller Class
// The middleman. It listens to the user, updates the Model, and refreshes the View.
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    // Methods to update the Model
    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentName() {
        return model.getName();
    }

    // Method to update the View
    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

// 5. Test Class
public class MVCPatternExample {
    public static void main(String[] args) {
        
        System.out.println("System: Booting up MVC Application...");

        // A. Fetch student record based on his roll no from the Singleton Database (Model)
        StudentDatabase database = StudentDatabase.getInstance();
        Student model = database.fetchStudent();

        // B. Create a view to output student details to console (View)
        StudentView view = new StudentView();

        // C. Create the controller to wire the Model and View together (Controller)
        StudentController controller = new StudentController(model, view);

        System.out.println("System: Initial Data Load...");
        controller.updateView();

        // D. Update model data via the controller
        System.out.println("System: Updating student grade after final exams...");
        controller.setStudentGrade("A");
        controller.setStudentName("Aarav Sharma");

        // E. Display the updated view
        controller.updateView();
    }
}