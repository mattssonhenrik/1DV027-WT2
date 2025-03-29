package dv027api.GraphQL;

import dv027api.Service.SeedBooksService;

import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.MutationMapping;

@Controller
public class DatabaseMutation {
  private SeedBooksService seedBooksService;

  public DatabaseMutation(SeedBooksService seedBooksService) {
    this.seedBooksService = seedBooksService;
  }

  @MutationMapping
  public String seedBooks() {
    return seedBooksService.seedBooks();
  }

  @MutationMapping
  public String clearBooks() {
    return seedBooksService.clearAllBooks();
  }

}
