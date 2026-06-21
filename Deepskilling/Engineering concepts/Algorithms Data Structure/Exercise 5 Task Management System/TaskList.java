class Node {
    public Task task;
    public Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}
public class TaskList {
    private Node head;

    public TaskList() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        
        if (head == null) {
            head = newNode;
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public Task searchTask(String taskId) {
        Node current = head;
        
        while (current != null) {
            if (current.task.getTaskId().equalsIgnoreCase(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public boolean deleteTask(String taskId) {
        if (head == null) {
            return false;
        }

        if (head.task.getTaskId().equalsIgnoreCase(taskId)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equalsIgnoreCase(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }

        return false;
    }
}