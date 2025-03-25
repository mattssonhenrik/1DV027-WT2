package dv027api.GraphQL;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import dv027api.Repository.BookRepository;
import dv027api.Model.Book;
import java.util.List;

@Controller
public class BookQuery {
  private final BookRepository bookRepository;

  public BookQuery(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @QueryMapping
  public List<Book> allBooks() {
    return bookRepository.findAll();
  }
}