package dv027api.Service;

import org.springframework.stereotype.Service;
import dv027api.Repository.BookRepository;

@Service
public class BookServiceImplementation implements BookService {
  private BookRepository bookRepository;

  public BookServiceImplementation(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }
  public void greeting() {
    System.out.println("Hi from Book-ServiceClass!");
  }
}
