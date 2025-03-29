package dv027api.Service;

import dv027api.Model.Book;
import java.util.List;

public interface BookService {
  List <Book> getAllBooks();
  Book getOneBookByIsbn(String isbn13);
  Book addBook(String isbn13, String title, String author, double rating);
  Book updateBook(String isbn13, String title, String author, double rating);
  boolean deleteBook(String isbn13);
}
