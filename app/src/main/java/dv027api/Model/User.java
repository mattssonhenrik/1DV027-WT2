package dv027api.Model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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

  // A default constructor which we need for JPA to work
  public User() {

  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Integer getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public Book getFavoriteBook() {
    return favoriteBook;
  }

  public void setFavoriteBook(Book favoriteBook) {
    this.favoriteBook = favoriteBook;
  }
}
