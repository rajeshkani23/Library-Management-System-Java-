package library;

import java.util.List;
import java.util.Scanner;

public class LibraryMenu {


    private Library library;
    private Scanner scanner;

    public LibraryMenu(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("===== Library Management System Menu =====");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Find Books by Title");
            System.out.println("4. Find Books by Author");
            System.out.println("5. List All Books");
            System.out.println("6. List Available Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    findBooksByTitle();
                    break;
                case 4:
                    findBooksByAuthor();
                    break;
                case 5:
                    listAllBooks();
                    break;
                case 6:
                    listAvailableBooks();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }

    private void addBook() {
        System.out.println("Enter book details:");
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Publication Year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Department: ");
        String department = scanner.nextLine();

        Book book = new Book(title, author, ISBN, genre, publicationYear, department);
        library.addBook(book);
    }

    private void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String ISBN = scanner.nextLine();
        library.removeBook(ISBN);
    }

    private void findBooksByTitle() {
        System.out.print("Enter title to search for: ");
        String title = scanner.nextLine();
        List<Book> books = library.findBookByTitle(title);
        if (books.isEmpty()) {
            System.out.println("No books found with title '" + title + "'");
        } else {
            System.out.println("Books found with title '" + title + "':");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void findBooksByAuthor() {
        System.out.print("Enter author to search for: ");
        String author = scanner.nextLine();
        List<Book> books = library.findBookByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("No books found by author '" + author + "'");
        } else {
            System.out.println("Books found by author '" + author + "':");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void listAllBooks() {
        List<Book> books = library.listAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("All books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void listAvailableBooks() {
        List<Book> books = library.listAvailableBooks();
        if (books.isEmpty()) {
            System.out.println("No available books in the library.");
        } else {
            System.out.println("Available books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
