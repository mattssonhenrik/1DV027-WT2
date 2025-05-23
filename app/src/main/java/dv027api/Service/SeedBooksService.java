package dv027api.Service;

import dv027api.Model.Book;
import dv027api.Model.User;
import dv027api.Repository.BookRepository;
import dv027api.Repository.UserRepository;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import com.opencsv.CSVReader;

/**
 * Service for seeding and clearing the books table using a CSV file.
 */
@Service
public class SeedBooksService {
  private BookRepository bookRepository;
  private UserRepository userRepository;
  private int inserted;

  /**
   * Constructs the service with the required repositories.
   *
   * @param bookRepository the book repository
   * @param userRepository the user repository
   */
  public SeedBooksService(BookRepository bookRepository, UserRepository userRepository) {
    this.bookRepository = bookRepository;
    this.userRepository = userRepository;
  }

  /**
   * Seeds the books table using data from <code>resources/data/books.csv</code>.
   * Skips duplicates and malformed entries.
   *
   * @return a message indicating success or failure
   */
  public String seedBooks() {
    if (bookRepository.count() > 0) {
      System.out.println("Books table is already seeded");
      return "Books table is already seeded. You need to use clearBooks mutation first.";
    }

    InputStream input = getClass().getClassLoader().getResourceAsStream("data/books.csv");
    if (input == null) {
      System.out.println("Could not find books.csv");
      return "Something wrong with the file!";
    }

    try (
        InputStreamReader isReader = new InputStreamReader(input);
        CSVReader reader = new CSVReader(isReader)) {
      String[] line;
      boolean isFirstLine = true;
      Set<String> seenIsbn = new HashSet<>();
      List<Book> booksToInsert = new ArrayList<>();

      while ((line = reader.readNext()) != null) {
        if (isFirstLine) {
          isFirstLine = false;
          continue;
        }

        try {
          String isbn13 = line[5].trim();
          String title = line[1].trim();
          String author = line[2].trim();
          double rating = Double.parseDouble(line[3].trim());

          if (isbn13.isEmpty() || seenIsbn.contains(isbn13))
            continue;

          if (isbn13.length() > 255)
            isbn13 = isbn13.substring(0, 255);
          if (title.length() > 255)
            title = title.substring(0, 255);
          if (author.length() > 255)
            author = author.substring(0, 255);

          seenIsbn.add(isbn13);
          Book book = new Book(isbn13, title, author, rating);
          booksToInsert.add(book);

          inserted++;

        } catch (Exception e) {
          continue;
        }
      }
      bookRepository.saveAll(booksToInsert);
    } catch (Exception e) {
      e.printStackTrace();
      return "An error happened with the seeding: " + e.getMessage();
    }

    System.out.println("Seeded successfully. Inserted " + inserted + " books!");
    inserted = 0;
    return "Seeded success";
  }

  public String clearAllBooks() {
    List<User> users = userRepository.findAll();
    for (User user : users) {
      user.setFavoriteBook(null);
    }
    userRepository.saveAll(users);
    bookRepository.deleteAll();
    return "Book cleared.";
  }
}
