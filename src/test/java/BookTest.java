import library.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {

    @Test
    public void testBookCreation() {
        // Create a book object
        Book book = new Book("Test Title", "Test Author", "1234567890", "Test Genre", 2023, "Test Department");

        // Test getters
        assertEquals("Test Title", book.getTitle());
        assertEquals("Test Author", book.getAuthor());
        assertEquals("1234567890", book.getISBN());
        assertEquals("Test Genre", book.getGenre());
        assertEquals(2023, book.getPublicationYear());
        assertEquals("Test Department", book.getDepartment());
        assertEquals(true, book.isAvailable());
    }

    @Test
    public void testUniqueIdentifierGeneration() {
        // Create two books with the same ISBN
        Book book1 = new Book("Title 1", "Author 1", "1234567890", "Genre 1", 2023, "Department 1");
        Book book2 = new Book("Title 2", "Author 2", "1234567890", "Genre 2", 2024, "Department 2");

        // Check that books with the same ISBN have the same unique identifier
        assertEquals("Title 1_Author 1_1234567890", book1.getUniqueIdentifier());
        assertEquals("Title 2_Author 2_1234567890", book2.getUniqueIdentifier());
    }
}
