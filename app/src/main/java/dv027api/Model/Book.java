package dv027api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a book entity stored in the database.
 */
@Entity
@Table(name = "books")
public class Book {

  @Id
  private String isbn13;
  private String title;
  private String author;
  private double rating;

  /**
   * Default constructor required by JPA.
   */
  public Book() {
  }

  /**
   * Creates a new Book with the given details.
   *
   * @param isbn13 the book's ISBN-13 identifier
   * @param title  the title of the book
   * @param author the author of the book
   * @param rating the average rating of the book
   */
  public Book(String isbn13, String title, String author, double rating) {
    this.isbn13 = isbn13;
    this.title = title;
    this.author = author;
    this.rating = rating;
  }

  /**
   * @return the ISBN-13 of the book
   */
  public String getIsbn13() {
    return isbn13;
  }

  /**
   * @param isbn13 sets the ISBN-13 of the book
   */
  public void setIsbn13(String isbn13) {
    this.isbn13 = isbn13;
  }

  /**
   * @return the title of the book
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title sets the title of the book
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the author of the book
   */
  public String getAuthor() {
    return author;
  }

  /**
   * @param author sets the author of the book
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * @return the rating of the book
   */
  public double getRating() {
    return rating;
  }

  /**
   * @param rating sets the rating of the book
   */
  public void setRating(double rating) {
    this.rating = rating;
  }
}
