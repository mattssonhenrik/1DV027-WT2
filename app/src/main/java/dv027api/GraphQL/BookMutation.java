package dv027api.GraphQL;

import dv027api.Service.BookService;
import dv027api.Model.Book;

import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;

@Controller
public class BookMutation {
  private BookService bookService;
  
    public BookMutation(BookService bookService) {
      this.bookService = bookService;
    }
  
    @MutationMapping
    public Book addBook(@Argument String isbn13, @Argument String title, @Argument String author, @Argument double rating) {
      Book newBook = bookService.addBook(isbn13, title, author, rating);
      return newBook;
    }
  
    @MutationMapping
    public Book updateBook(@Argument String isbn13, @Argument String title, @Argument String author, @Argument double rating) {
      Book updatedBook = bookService.updateBook(isbn13, title, author, rating);
      return updatedBook;
    }
  
    @MutationMapping
    public boolean deleteBook(@Argument String isbn13) {
    boolean deletedOrNot = bookService.deleteBookByIsbn(isbn13);
    return deletedOrNot;
  }

}