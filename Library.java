import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * A library management class. Has a simple shell that users can interact with to add/remove/checkout/list books in the library.
 * Also allows saving the library state to a file and reloading it from the file.
 */
public class Library {

    private List<Book> books = new ArrayList<>();

    /**
     * @return the number of books (not number of copies) in the library.
     */
    public int getNumberOfBooks() {
        // TODO: Implement this method.
        return books.size();
    }

    /**
     * Adds a book to the library. If the library already has this book then it
     * adds the number of copies the library has.
     */
    public void addBook(Book book) {
        // TODO: Implement this method.
        for (Book b : books) {
            if (b.equals(book)) {
                b.addCopies(book.getNumberOfCopies());
                return;
            }
        }
        books.add(book);
    }

    /**
     * Checks out the given book from the library. Throw the appropriate
     * exception if book doesnt exist or there are no more copies available.
     */
    public void checkout(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                if (book.getAvailableCopies() > 0) {
                    book.setAvailableCopies(book.getAvailableCopies() - 1);
                    System.out.println("Book checked out successfully.");
                    return;
                } else {
                    System.out.println("Error: No copies available for checkout.");
                    return;
                }
            }
        }
        System.out.println("Error: Book with ISBN " + isbn + " not found.");
    }

    /**
     * Returns a book to the library.
     */
    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                if (book.getAvailableCopies() < book.getNumberOfCopies()) {
                    book.setAvailableCopies(book.getAvailableCopies() + 1);
                    System.out.println("Book returned successfully.");
                    return;
                } else {
                    System.out.println("Error: All copies are already in the library.");
                    return;
                }
            }
        }
        System.out.println("Error: Book with ISBN " + isbn + " not found.");
    }

    /**
     * Finds this book in the library. Throws appropriate exception if the book
     * doesnt exist.
     */
    public Book findByTitleAndAuthor(String title, String author) {
        // TODO: Implement this method.
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Finds this book in the library. Throws appropriate exception if the book
     * doesnt exist.
     */
    public Book findByISBN(String isbn) {
        // TODO: Implement this method.
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        throw new UnsupportedOperationException("not implemented");
    }

    /**
     * Saves the contents of this library to the given file.
     */
    public void save(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
        for (Book book : books) {
            writer.println(book.getTitle() + "," +
                           book.getAuthor() + "," +
                           book.getIsbn() + "," +
                           book.getPublicationYear() + "," +
                           book.getNumberOfCopies() + "," +
                           book.getAvailableCopies());
        }
        System.out.println("Library saved to " + filename);
    } catch (IOException e) {
        System.out.println("Error saving library to file: " + e.getMessage());
    }
}
    /**
     * Loads the contents of this library from the given file. All existing data
     * in this library is cleared before loading from the file.
     */
    public void load(String filename) {
        // TODO: Implement this method.
        throw new UnsupportedOperationException("not implemented");
    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        	Library library = new Library();

		while (true) {
			System.out.print("library> ");
			String line = scanner.nextLine();
			// TODO: Implement code 
			if (line.startsWith("add")) {
				// TODO: Implement this case.
			} else if (line.startsWith("checkout")) {
				// Format: checkout ISBN-1234
				String[] parts = line.split(" ");
				if (parts.length == 2) {
					String isbn = parts[1];
					new Library().checkout(isbn);
				} else {
					System.out.println("Usage: checkout <isbn>");
				}
			} else if (line.startsWith("findByTitleAndAuthor")) {
				// TODO: Implement this case.
                String[] tokens = line.split(" ");
                if (tokens.length < 3) {
                    System.out.println("Error: Invalid format. Usage: findByTitleAndAuthor <title> <author>");
                    return;
                }
                // Combine tokens to reconstruct title and author (only 2 parts assumed)
                String titleRaw = tokens[1];
                String authorRaw = tokens[2];
                // Replace underscores with spaces
                String title = titleRaw.replace("_", " ");
                String author = authorRaw.replace("_", " ");
                try {
                    Book book = library.findByTitleAndAuthor(title, author); // assumes library is your library object
                    System.out.println(book.getIsbn() + " " + book.getNumberOfCopies() + " " + book.getAvailableCopies());
                } 
                catch (NoSuchElementException e) {
                    System.out.println("Error: Book not found with title \"" + title + "\" and author \"" + author + "\".");
                }
            
			} else if (line.startsWith("return")) {
				// Format: return ISBN-1234
				String[] parts = line.split(" ");
				if (parts.length == 2) {
					String isbn = parts[1];
					new Library().returnBook(isbn);  // for testing
				} else {
					System.out.println("Usage: return <isbn>");
				}
			} else if (line.startsWith("list")) {
				// TODO: Implement this case.
                String[] tokens = line.split(" ");
                if (tokens.length < 2) {
                    System.out.println("Error: Invalid format. Usage: list <isbn>");
                    return;
                }
                String isbn = tokens[1];
                try {
                Book book = library.findByISBN(isbn);
                System.out.println(book.getNumberOfCopies() + " " + book.getAvailableCopies());
                } catch (NoSuchElementException e) {
                    System.out.println("Error: Book with ISBN \"" + isbn + "\" not found.");
                }
			} else if (line.startsWith("save")) {
				String[] parts = line.split(" ");
		                if (parts.length == 2) {
		                    String filename = parts[1];
		                    library.save(filename);
		                } else {
		                    System.out.println("Usage: save <filename>");
		                }    
			} else if (line.startsWith("load")) {
				// TODO: Implement this case.
			} else if (line.startsWith("exit")) {
				break;
			}
		}
	}
}
