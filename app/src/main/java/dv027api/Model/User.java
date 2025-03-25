package dv027api.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
