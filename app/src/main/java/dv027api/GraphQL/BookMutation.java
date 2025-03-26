package dv027api.GraphQL;

import dv027api.Repository.BookRepository;
import dv027api.Service.SeedBooksService;

import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.MutationMapping;


@Controller
public class BookMutation {
  private final SeedBooksService seedBooksService;
  private final BookRepository bookRepository;

  public BookMutation(SeedBooksService seedBooksService, BookRepository bookRepository) {
    this.seedBooksService = seedBooksService;
    this.bookRepository = bookRepository;
  }

  @MutationMapping
  public String seedBooks() {
    return seedBooksService.seedBooks();
  }

  @MutationMapping
  public String clearBooks() {
    bookRepository.deleteAll();
    return "Books cleared.";
  }
}