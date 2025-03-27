package dv027api.GraphQL;

import dv027api.Repository.UserRepository;
import dv027api.Service.UserService;
import dv027api.Util.JWTUtil;
import dv027api.Model.User;

import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import java.util.Optional;

@Controller
public class UserMutation {
  private UserRepository userRepository;
  private UserService userService;
  private JWTUtil jwtUtil;
  private boolean success = false;

  public UserMutation (UserRepository userRepository, UserService userService, JWTUtil jwtUtil) {
    this.userRepository = userRepository;
    this.userService = userService;
    this.jwtUtil = jwtUtil;
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
      return userRepository.findByUsername(username)
      .map(user -> {
          String token = jwtUtil.generateToken(user.getUsername(), user.getId());
          return "Success! You're logged in. Here is your JWT: " + token;
      })
      .orElse("Something went wrong!");
    }
    
    
  }
}
