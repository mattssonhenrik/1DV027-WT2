package dv027api.Controller;

import dv027api.Model.Book;
import dv027api.Service.BookService;
import dv027api.Service.SeedBooksService;
import dv027api.View.BookView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
  private BookService bookService;
  private BookView bookView;
  private SeedBooksService seedBooksService;

  public BookController(BookService bookService, BookView bookView, SeedBooksService seedBooksService) {
    this.bookService = bookService;
    this.bookView = bookView;
    this.seedBooksService = seedBooksService;
  }

  // @GetMapping("/all")
  // public List<Book> getAllBooks() {
  //   return bookRepository.findAll();
  // }

  @GetMapping("/seed")
  public String seedBooks() {
    seedBooksService.seedBooks();
    return "Seeding in process!";
  }

}
