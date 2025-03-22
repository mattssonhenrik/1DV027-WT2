package dv027api.Controller;

import dv027api.Service.BookService;
import dv027api.View.BookView;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component // Ta bort senare, behövs nog inte
@Controller
public class BookController {
  private BookService bookService;
  private BookView bookView;

  public BookController(BookService bookService, BookView bookView) {
    this.bookService = bookService;
    this.bookView = bookView;

    System.out.println("BookController constructor is running!");
    this.greeting();
  }

  public void greeting() {
    System.out.println("Hi from Book-Controller-class!");
    // movieService.greeting();
    // movieView.greeting();
}
}
