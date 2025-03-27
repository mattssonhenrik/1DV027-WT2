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
  private boolean success = false;

  public UserMutation (UserRepository userRepository, UserService userService) {
    this.userRepository = userRepository;
    this.userService = userService;
  }

  @MutationMapping
  public String registerUser(@Argument String username, @Argument String password){
    success = userService.registerUser(username, password);
    if (success == false) {
      return "Username is occupied, try again with other credentials";
    } else {
      return "Success! You've registered a new user " + username + ".";
    }
  }

  @MutationMapping
  public String loginUser(@Argument String username, @Argument String password){
    success = userService.loginUser(username, password);
    if (success == false) {
      return "Wrong credentials, please try again or register a new account!";
    } else {
      return "Success! You're logged in.";
    }
    
    
  }
}
