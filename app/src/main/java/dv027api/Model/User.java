package dv027api.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Represents a user in the system.
 * A user may optionally have a favorite book.
 */
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(unique = true, nullable = false)
  private String username;
  @Column(nullable = false)
  private String password;
  @ManyToOne
  @JoinColumn(name = "favorite_isbn13") // Setting this as a forgein key (primary key book)
  private Book favoriteBook;

  /**
   * Default constructor required by JPA.
   */
  public User() {

  }

  /**
   * Constructs a User with a username and password.
   *
   * @param username the user's username
   * @param password the user's password
   */
  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  /**
   * @return the user's ID
   */
  public Integer getId() {
    return id;
  }

  /**
   * @return the user's username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @return the user's password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @return the user's favorite book
   */
  public Book getFavoriteBook() {
    return favoriteBook;
  }

  /**
   * @param favoriteBook sets the user's favorite book
   */
  public void setFavoriteBook(Book favoriteBook) {
    this.favoriteBook = favoriteBook;
  }
}
