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

  public book (String isbn13, String title, String author, double rating) {
    this.isbn13 = isbn13;
    this.title = title;
    this.author = author;
    this.rating = rating;
  }

}
