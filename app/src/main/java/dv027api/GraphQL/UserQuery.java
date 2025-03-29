package dv027api.GraphQL;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import dv027api.Repository.UserRepository;
import dv027api.Model.User;
import java.util.List;

@Controller
public class UserQuery {
  private UserRepository userRepository;

  public UserQuery(UserRepository userRepository) {
    this.userRepository = userRepository;  
  }

  @QueryMapping
  public List<User> allUsers() {
    return userRepository.findAll();
  }

  @QueryMapping
  public User getUserByUsername(@Argument String username) {
    return userRepository.findByUsername(username).orElseThrow(null);
  }
}
