package dv027api.GraphQL;

import dv027api.Repository.BookRepository;
import dv027api.Service.SeedBooksService;
import dv027api.Model.Book;

import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.MutationMapping;


@Controller
public class BookMutation {
  private SeedBooksService seedBooksService;
  private BookRepository bookRepository;

  public BookMutation(SeedBooksService seedBooksService, BookRepository bookRepository) {
    this.seedBooksService = seedBooksService;
    this.bookRepository = bookRepository;
  }

  @MutationMapping
  public Book addBook(String isbn13, String title, String author, double rating) {
    bookRepository.save(Book newBook = new Book(isbn13, title, author, rating));
  }

  @MutationMapping
  public Book updateBook() {
    
  }

  @MutationMapping
  public boolean deleteBook() {
    
  }

}