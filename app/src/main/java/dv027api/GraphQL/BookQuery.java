package dv027api.GraphQL;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import dv027api.Service.BookService;
import dv027api.Model.Book;
import java.util.List;

/**
 * GraphQL query controller for fetching book data.
 */
@Controller
public class BookQuery {
  private BookService bookService;

  /**
   * Constructs a BookQuery controller with the injected BookService.
   *
   * @param bookService the book service used for querying books
   */
  public BookQuery(BookService bookService) {
    this.bookService = bookService;
  }

  /**
   * Returns a list of all books.
   *
   * @return list of all Book objects
   */
  @QueryMapping
  public List<Book> allBooks() {
    return bookService.getAllBooks();
  }

  /**
   * Returns a single book by its ISBN-13.
   *
   * @param isbn13 the ISBN-13 of the book to retrieve
   * @return the Book object if found, or null otherwise
   */
  @QueryMapping
  public Book getBookByIsbn(@Argument String isbn13) {
    return bookService.getOneBookByIsbn(isbn13);
  }
}