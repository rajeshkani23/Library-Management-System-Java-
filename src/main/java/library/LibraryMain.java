package library;

import java.util.List;

public class LibraryMain {

    public static void main(String[] args) {
        // Create a new library
        Library library = new Library();

        // Add some books to the library
        Book book1 = new Book("Book 1", "Author A", "1234567890", "Fiction", 2020, "Department A");
        Book book2 = new Book("Book 2", "Author B", "2345678901", "Non-fiction", 2021, "Department B");
        Book book3 = new Book("Book 3", "Author A", "3456789012", "Science", 2019, "Department A");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // List all books in the library
        System.out.println("All books in the library:");
        List<Book> allBooks = library.listAllBooks();
        for (Book book : allBooks) {
            System.out.println(book);
        }

        // Find books by title
        System.out.println("\nBooks with title 'Book 1':");
        List<Book> booksByTitle = library.findBookByTitle("Book 1");
        for (Book book : booksByTitle) {
            System.out.println(book);
        }

        // Find books by author
        System.out.println("\nBooks by author 'Author A':");
        List<Book> booksByAuthor = library.findBookByAuthor("Author A");
        for (Book book : booksByAuthor) {
            System.out.println(book);
        }

        // Remove a book by ISBN
        String ISBNToRemove = "2345678901";
        System.out.println("\nRemoving book with ISBN " + ISBNToRemove);
        library.removeBook(ISBNToRemove);

        // List available books
        System.out.println("\nAvailable books in the library:");
        List<Book> availableBooks = library.listAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }
}
