package dv027api.GraphQL;

import dv027api.Service.BookService;
import dv027api.Model.Book;

import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;

/**
 * GraphQL mutation controller for managing books (add, update, delete).
 */
@Controller
public class BookMutation {
  private BookService bookService;

  /**
   * Constructs a BookMutation controller with the injected BookService.
   *
   * @param bookService the book service used for mutation operations
   */
  public BookMutation(BookService bookService) {
    this.bookService = bookService;
  }

  /**
   * Adds a new book to the system.
   *
   * @param isbn13 the book's ISBN-13
   * @param title  the book title
   * @param author the book author
   * @param rating the book rating
   * @return the added Book object
   */
  @MutationMapping
  public Book addBook(@Argument String isbn13, @Argument String title, @Argument String author,
      @Argument double rating) {
    Book newBook = bookService.addBook(isbn13, title, author, rating);
    return newBook;
  }

  /**
   * Updates an existing book.
   *
   * @param isbn13 the ISBN-13 of the book to update
   * @param title  the new title
   * @param author the new author
   * @param rating the new rating
   * @return the updated Book object, or null if not found
   */
  @MutationMapping
  public Book updateBook(@Argument String isbn13, @Argument String title, @Argument String author,
      @Argument double rating) {
    Book updatedBook = bookService.updateBook(isbn13, title, author, rating);
    return updatedBook;
  }

  /**
   * Deletes a book by its ISBN-13.
   *
   * @param isbn13 the ISBN-13 of the book to delete
   * @return true if the book was deleted, false otherwise
   */
  @MutationMapping
  public boolean deleteBook(@Argument String isbn13) {
    boolean deletedOrNot = bookService.deleteBookByIsbn(isbn13);
    return deletedOrNot;
  }

}