package dv027api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

  @Id
  private String isbn13;
  private String title;
  private String author;
  private double rating;

  // Default constructor for JPA (Jakarta PErsistance)
  public Book() {
  }

  public Book(String isbn13, String title, String author, double rating) {
    this.isbn13 = isbn13;
    this.title = title;
    this.author = author;
    this.rating = rating;
  }

  public String getIsbn13() {
    return isbn13;
  }

  public void setIsbn13(String isbn13) {
    this.isbn13 = isbn13;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }
}
