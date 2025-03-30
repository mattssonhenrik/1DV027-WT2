package dv027api.GraphQL;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import dv027api.Repository.UserRepository;
import dv027api.Model.User;
import java.util.List;

/**
 * GraphQL query controller for fetching user data.
 */
@Controller
public class UserQuery {
  private UserRepository userRepository;

  /**
   * Constructs a UserQuery with the provided UserRepository.
   *
   * @param userRepository repository for user data
   */
  public UserQuery(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Fetches all users in the database.
   *
   * @return list of all users
   */
  @QueryMapping
  public List<User> allUsers() {
    return userRepository.findAll();
  }

  /**
   * Fetches a user by their username.
   *
   * @param username the username to search for
   * @return the matching user
   */
  @QueryMapping
  public User getUserByUsername(@Argument String username) {
    return userRepository.findByUsername(username).orElseThrow(null);
  }
}
