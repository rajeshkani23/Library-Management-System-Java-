package library;

import java.util.*;

public class Library {
    private Map<String, List<Book>> departments;

    public Library() {
        this.departments = new HashMap<>();
    }

    public void addBook(Book book) {
        String department = book.getDepartment();

        // Check if department already exists
        if (!departments.containsKey(department)) {
            departments.put(department, new ArrayList<>());
        }

        // Check if book with same ISBN exists in the department
        List<Book> booksInDepartment = departments.get(department);
        if (isBookInDepartment(booksInDepartment, book.getISBN())) {
            System.out.println("Book with ISBN " + book.getISBN() + " already exists in department " + department);
            return;
        }

        // Add book to the department
        booksInDepartment.add(book);
    }

    private boolean isBookInDepartment(List<Book> booksInDepartment, String ISBN) {
        for (Book book : booksInDepartment) {
            if (book.getISBN().equals(ISBN)) {
                return true;
            }
        }
        return false;
    }

    public void removeBook(String ISBN) {
        for (List<Book> books : departments.values()) {
            Iterator<Book> iterator = books.iterator();
            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.getISBN().equals(ISBN)) {
                    iterator.remove();
                    return;
                }
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found in any department");
    }

    public List<Book> findBookByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (List<Book> books : departments.values()) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    result.add(book);
                }
            }
        }
        return result;
    }

    public List<Book> findBookByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (List<Book> books : departments.values()) {
            for (Book book : books) {
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    result.add(book);
                }
            }
        }
        return result;
    }

    public List<Book> listAllBooks() {
        List<Book> result = new ArrayList<>();
        for (List<Book> books : departments.values()) {
            result.addAll(books);
        }
        return result;
    }

    public List<Book> listAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (List<Book> books : departments.values()) {
            for (Book book : books) {
                if (book.isAvailable()) {
                    result.add(book);
                }
            }
        }
        return result;
    }
}
