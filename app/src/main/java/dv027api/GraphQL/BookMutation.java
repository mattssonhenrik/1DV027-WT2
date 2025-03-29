package dv027api.GraphQL;

import dv027api.Service.BookService;
import dv027api.Model.Book;

import org.springframework.stereotype.Controller;


import org.springframework.graphql.data.method.annotation.MutationMapping;

@Controller
public class BookMutation {
  private BookService bookService;
  
    public BookMutation(BookService bookService) {
      this.bookService = bookService;
    }
  
    @MutationMapping
    public Book addBook(String isbn13, String title, String author, double rating) {
      Book newBook = bookService.addBook(isbn13, title, author, rating);
      return newBook;
    }
  
    @MutationMapping
    public Book updateBook(String isbn13, String title, String author, double rating) {
      Book updatedBook = bookService.updateBook(null, null, null, 0);
      return updatedBook;
    }
  
    @MutationMapping
    public boolean deleteBook(String isbn13) {
    Boolean deletedOrNot = deleteBook(isbn13);
    return deletedOrNot;
  }

}