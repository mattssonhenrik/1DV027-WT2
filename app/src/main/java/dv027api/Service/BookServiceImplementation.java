package dv027api.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import dv027api.Model.Book;
import dv027api.Repository.BookRepository;

@Service
public class BookServiceImplementation implements BookService {
  private BookRepository bookRepository;

  public BookServiceImplementation(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  // Override annotation since we are using the interface method and want to make sure that the methodsignature (name, parameters whatever) is exactly as what is stated in the interface so we do not introduce a bug (like misspelling the name -> new method). 
  @Override 
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @Override 
  public Book getOneBookByIsbn(String isbn13) {
    return bookRepository.findById(isbn13).orElse(null);
  }

  @Override 
  public Book addBook(String isbn13, String title, String author, double rating) {
    Book newBook = new Book(isbn13, title, author, rating)
    bookRepository.save(newBook);
    return newBook;
  }

  @Override 
  public Book updateBook(String isbn13, String title, String author, double rating) {
    return bookRepository.findById(isbn13).map(book -> {
      book.setTitle(title);
      book.setAuthor(author);
      book.setRating(rating);
      return bookRepository.save(book);
    }).orElse(null);
  }

  @Override 
  public boolean deleteBook(String isbn13) {
    if (!bookRepository.existsById(isbn13)) return false;
    bookRepository.deleteById(isbn13);
    return true;
  }
}
