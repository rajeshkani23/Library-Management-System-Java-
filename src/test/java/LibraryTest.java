import library.Book;
import library.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
        Book book1 = new Book("Book 1", "Author 1", "1234567890", "Genre 1", 2021, "Department 1");
        Book book2 = new Book("Book 2", "Author 2", "2345678901", "Genre 2", 2022, "Department 2");
        Book book3 = new Book("Book 3", "Author 3", "3456789012", "Genre 3", 2023, "Department 1");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }

    @Test
    public void testAddBook() {
        Book newBook = new Book("New Book", "New Author", "4567890123", "New Genre", 2024, "Department 2");
        library.addBook(newBook);

        List<Book> books = library.listAllBooks();
        assertEquals(4, books.size());
    }

    @Test
    public void testRemoveBook() {
        library.removeBook("1234567890");

        List<Book> books = library.listAllBooks();
        assertEquals(2, books.size());
    }

    @Test
    public void testFindBookByTitle() {
        List<Book> books = library.findBookByTitle("Book 1");
        assertEquals(1, books.size());
    }

    @Test
    public void testFindBookByAuthor() {
        List<Book> books = library.findBookByAuthor("Author 2");
        assertEquals(1, books.size());
    }

    @Test
    public void testListAllBooks() {
        List<Book> books = library.listAllBooks();
        assertEquals(3, books.size());
    }

    @Test
    public void testListAvailableBooks() {
        List<Book> books = library.listAvailableBooks();
        assertEquals(3, books.size());
    }


}
