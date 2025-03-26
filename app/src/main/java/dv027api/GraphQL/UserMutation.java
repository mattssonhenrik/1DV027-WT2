package dv027api.GraphQL;

import dv027api.Repository.UserRepository;
import dv027api.Service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;

@Controller
public class UserMutation {
  private UserRepository userRepository;
  private UserService userService;

  public UserMutation (UserRepository userRepository, UserService userService) {
    this.userRepository = userRepository;
    this.userService = userService;
  }

  @MutationMapping
  public Boolean registerUser(@Argument String username, @Argument String password){
    return userService.registerUser(username, password);
  }

  @MutationMapping
  public Boolean loginUser(String username, String password) {
    return true;
  }
}
