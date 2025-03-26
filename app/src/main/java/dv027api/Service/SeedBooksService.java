package dv027api.Service;

import dv027api.Model.Book;
import dv027api.Repository.BookRepository;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;
import com.opencsv.CSVReader;

@Service
public class SeedBooksService {
  private BookRepository bookRepository;
  private int inserted;

  public SeedBooksService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

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

          seenIsbn.add(isbn13);
          Book book = new Book(isbn13, title, author, rating);
          bookRepository.save(book);
          inserted++;

        } catch (Exception e) {
          continue;
        }
      }
    } catch (Exception e) {
      return "An error happened with the seeding";
    }

    System.out.println("Seeded successfully. Inserted " + inserted + " books!");
    inserted = 0;
    return "Seeded success";
  }
}
