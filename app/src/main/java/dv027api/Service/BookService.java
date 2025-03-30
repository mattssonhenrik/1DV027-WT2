package dv027api.Service;

import dv027api.Model.Book;
import java.util.List;

/**
 * Service interface for book-related operations.
 */
public interface BookService {
  /**
   * Retrieves all books.
   *
   * @return a list of all books
   */
  List<Book> getAllBooks();

  /**
   * Retrieves a single book by its ISBN-13.
   *
   * @param isbn13 the ISBN-13 of the book
   * @return the matching Book, or null if not found
   */
  Book getOneBookByIsbn(String isbn13);

  /**
   * Adds a new book.
   *
   * @param isbn13 the ISBN-13 of the book
   * @param title  the title of the book
   * @param author the author of the book
   * @param rating the rating of the book
   * @return the created Book
   */
  Book addBook(String isbn13, String title, String author, double rating);

  /**
   * Updates an existing book.
   *
   * @param isbn13 the ISBN-13 of the book to update
   * @param title  the updated title
   * @param author the updated author
   * @param rating the updated rating
   * @return the updated Book
   */
  Book updateBook(String isbn13, String title, String author, double rating);

  /**
   * Deletes a book by its ISBN-13.
   *
   * @param isbn13 the ISBN-13 of the book to delete
   * @return true if deletion was successful, false otherwise
   */
  boolean deleteBookByIsbn(String isbn13);
}
