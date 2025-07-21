/**
 * Encapusulates information about a book.
 * @author Balaji Srinivasan
 */
public class Book {
    String title;
    String author;
    String isbn;
    int publicationYear;
    // number of copies in the library
    // NOTE: This is not the number of copies available in the library
    int numberOfCopies; 

    /**
     * Constructor. Most properties (except number of copies are read only)
     */
    public Book(String title, String author, String isbn, int publicationYear, int numberOfCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.numberOfCopies = numberOfCopies;
    }

    /**
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return the ISBN for this book.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @return The publication year of this book.
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * @return The number of copies of this book.
     */
    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    /**
     * @return The number of available copies of this book.
     */
    public int getAvailableCopies() {
        // TODO: Implement this method.
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Sets the number of available copies. Just used for testing.
     */
    public void setAvailableCopies(int numCopies) {
        // TODO: Implement this method.
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * Adds the given mumber of copies of this book to the library.
     */
    public void addCopies(int numCopiesToAdd) {
        numberOfCopies += numCopiesToAdd;
    }

    /** 
     * Checks out a book (decrements number of copies available in the library)
     * @throws RuntimeException if no copies are available to check out.
     */
    public void checkout() {
        // TODO: Implement this method.
        throw new UnsupportedOperationException("Not implemented");
    } 

    /** 
     * Checks in a book into the library.
     * @throws RuntimeException if no copies have been checked out.
     */
    public void checkin() {
        // TODO: Implement this method.
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public int hashCode() {
        // TODO: Implement an appropriate hash code for a book.
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean equals(Object that) {
        // TODO: Implement this method.
        // NOTE: Two books are the same only if the Title, Author, and ISBN matches
        throw new UnsupportedOperationException("Not implemented");
    }
}
