package dv027api.GraphQL;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import dv027api.Service.BookService;
import dv027api.Model.Book;
import java.util.List;

@Controller
public class BookQuery {
  private BookService bookService;

  public BookQuery(BookService bookService) {
    this.bookService = bookService;
  }

  @QueryMapping
  public List<Book> allBooks() {
    return bookService.getAllBooks();
  }

  @QueryMapping
  public Book getBookByIsbn(@Argument String isbn13) {
    return bookService.getOneBookByIsbn(isbn13);
  }
}