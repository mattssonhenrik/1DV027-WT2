package dv027api.GraphQL;

import dv027api.Repository.BookRepository;
import dv027api.Repository.UserRepository;
import dv027api.Service.UserService;
import dv027api.DTO.UserResponse;
import dv027api.Model.Book;
import dv027api.Model.User;
import dv027api.Util.JWTUtil;

import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;

@Controller
public class UserMutation {
  private UserRepository userRepository;
  private BookRepository bookRepository;
  private UserService userService;
  private JWTUtil jwtUtil;
  private boolean success = false;

  public UserMutation(UserRepository userRepository, BookRepository bookRepository, UserService userService,
      JWTUtil jwtUtil) {
    this.userRepository = userRepository;
    this.bookRepository = bookRepository;
    this.userService = userService;
    this.jwtUtil = jwtUtil;
  }

  // REGISTER
  @MutationMapping
  public UserResponse registerUser(@Argument String username, @Argument String password) {
    success = userService.registerUser(username, password);
    if (success == false) {
      return new UserResponse(false, "Username is occupied, choose another username.", null);
    } else {
      return new UserResponse(true, "Registration successful!", null);
    }
  }

  // LOGIN
  @MutationMapping
  public UserResponse loginUser(@Argument String username, @Argument String password) {
    success = userService.loginUser(username, password);
    if (!success) {
      return new UserResponse(false, "Wrong credentials, please try again or register a new account!", null);
    }
    return userRepository.findByUsername(username)
        .map(user -> {
          String token = jwtUtil.generateToken(user.getUsername(), user.getId());
          return new UserResponse(true, "Login successful!", token);
        })
        .orElse(new UserResponse(false, "Something went wrong!", null));
  }

  // FAVORITE BOOK CREATE OR UPDATE
  @MutationMapping
  public User addOrUpdateFavoriteBook(@Argument String username, @Argument String isbn13) {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("User not found"));
    Book book = bookRepository.findById(isbn13)
        .orElseThrow(() -> new RuntimeException("Book not found"));
    user.setFavoriteBook(book);
    return userRepository.save(user);
  }

  // FAVORITE BOOK DELETE
  @MutationMapping
  public User removeFavoriteBook(@Argument String username) {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("User not found"));
    user.setFavoriteBook(null);
    return userRepository.save(user);
  }
}