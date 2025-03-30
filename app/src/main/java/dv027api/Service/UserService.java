package dv027api.Service;

import dv027api.Model.User;
import dv027api.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service for managing user registration and login.
 */
@Service
public class UserService {
  private UserRepository userRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  /**
   * Constructs the UserService with the given UserRepository.
   *
   * @param userRepository the user repository
   */
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
  }

  /**
   * Registers a new user with a unique username.
   * The password is salted and hashed using BCrypt.
   *
   * @param username the desired username
   * @param password the plaintext password
   * @return true if registration succeeded, false if username is already taken
   */
  public Boolean registerUser(String username, String password) {
    if (userRepository.findByUsername(username).isPresent()) {
      return false;
    }

    String saltedAndHashedPassword = bCryptPasswordEncoder.encode(password);
    User newUser = new User(username, saltedAndHashedPassword);
    userRepository.save(newUser);
    return true;
  }

  /**
   * Authenticates a user by verifying the password against the stored hash.
   *
   * @param username the user's username
   * @param password the plaintext password
   * @return true if login is successful, false otherwise
   */
  public Boolean loginUser(String username, String password) {
    return userRepository.findByUsername(username)
        .map(user -> bCryptPasswordEncoder.matches(password, user.getPassword()))
        .orElse(false);
  }
}
