import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book[] library = {
            new Book("B01", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B02", "1984", "George Orwell"),
            new Book("B03", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B04", "Pride and Prejudice", "Jane Austen"),
            new Book("B05", "Moby Dick", "Herman Melville")
        };

        String searchTitle = "1984";

        Book foundLinear = LibrarySearch.linearSearchByTitle(library, searchTitle);
        System.out.println("Linear Search: " + (foundLinear != null ? foundLinear : "Not Found"));

        Arrays.sort(library, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        Book foundBinary = LibrarySearch.binarySearchByTitle(library, searchTitle);
        System.out.println("Binary Search: " + (foundBinary != null ? foundBinary : "Not Found"));
    }
}