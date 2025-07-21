import java.util.Objects;

/**
 * Encapsulates information about a book in the library system.
 * Supports tracking total and available copies, checkout/checkin,
 * and equality based on title, author, and ISBN.
 *
 * @author Balaji.Srinivasan
 */
public class Book {
    // Title of the book (immutable)
    private final String title;
    // Author of the book (immutable)
    private final String author;
    // ISBN identifier (immutable)
    private final String isbn;
    // Publication year (immutable)
    private final int publicationYear;
    // Total copies in the library
    private int totalCopies;
    // Copies currently available for checkout
    private int availableCopies;

    /**
     * Constructor: initializes book metadata and sets both total and available copies.
     * @param title book title
     * @param author book author
     * @param isbn unique ISBN
     * @param publicationYear year of publication
     * @param numberOfCopies initial number of copies
     * @throws IllegalArgumentException if numberOfCopies is negative
     */
    public Book(String title, String author, String isbn, int publicationYear, int numberOfCopies) {
        if (numberOfCopies < 0) {
            throw new IllegalArgumentException("Number of copies cannot be negative");
        }
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.totalCopies = numberOfCopies;
        this.availableCopies = numberOfCopies;
    }

    /** @return the book's title */
    public String getTitle() {
        return title;
    }

    /** @return the book's author */
    public String getAuthor() {
        return author;
    }

    /** @return the book's ISBN */
    public String getIsbn() {
        return isbn;
    }

    /** @return the publication year */
    public int getPublicationYear() {
        return publicationYear;
    }

    /** @return total number of copies held by the library */
    public int getNumberOfCopies() {
        return totalCopies;
    }

    /** @return number of copies currently available for checkout */
    public int getAvailableCopies() {
        return availableCopies;
    }

    /**
     * Sets the number of available copies (for testing/use cases).
     * @param numCopies new available count
     * @throws IllegalArgumentException if numCopies out of range [0, totalCopies]
     */
    public void setAvailableCopies(int numCopies) {
        if (numCopies < 0 || numCopies > totalCopies) {
            throw new IllegalArgumentException(
                "Available copies must be between 0 and total copies");
        }
        this.availableCopies = numCopies;
    }

    /**
     * Adds copies to the library collection, increasing both total and available counts.
     * @param numCopiesToAdd number of copies to add
     * @throws IllegalArgumentException if numCopiesToAdd <= 0
     */
    public void addCopies(int numCopiesToAdd) {
        if (numCopiesToAdd <= 0) {
            throw new IllegalArgumentException("Must add at least one copy");
        }
        totalCopies += numCopiesToAdd;
        availableCopies += numCopiesToAdd;
    }

    /**
     * Checks out one copy if available.
     * @throws RuntimeException if no copies are available
     */
    public void checkout() {
        if (availableCopies <= 0) {
            throw new RuntimeException("No copies available for checkout");
        }
        availableCopies--;
    }

    /**
     * Checks in one copy.
     * @throws RuntimeException if all copies are already checked in
     */
    public void checkin() {
        if (availableCopies >= totalCopies) {
            throw new RuntimeException("All copies are already returned");
        }
        availableCopies++;
    }

    /**
     * Hash code based on title, author, and ISBN.
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, author, isbn);
    }

    /**
     * two books are the same if title, author, and ISBN match.
     * @param obj other object
     * @return true if equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book other = (Book) obj;
        return Objects.equals(title, other.title)
            && Objects.equals(author, other.author)
            && Objects.equals(isbn, other.isbn);
    }
}
