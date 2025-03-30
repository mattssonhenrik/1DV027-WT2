package dv027api.GraphQL;

import dv027api.Service.SeedBooksService;

import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.MutationMapping;

/**
 * GraphQL mutation controller for database seeding and cleanup.
 */
@Controller
public class DatabaseMutation {
  private SeedBooksService seedBooksService;

  /**
   * Constructs a DatabaseMutation controller with the injected SeedBooksService.
   *
   * @param seedBooksService service responsible for seeding and clearing books
   */
  public DatabaseMutation(SeedBooksService seedBooksService) {
    this.seedBooksService = seedBooksService;
  }

  /**
   * Seeds the database with book data from a CSV file.
   *
   * @return a status message describing the result
   */
  @MutationMapping
  public String seedBooks() {
    return seedBooksService.seedBooks();
  }

  /**
   * Clears all books from the database and resets any foreign key references.
   *
   * @return a status message describing the result
   */
  @MutationMapping
  public String clearBooks() {
    return seedBooksService.clearAllBooks();
  }

}
