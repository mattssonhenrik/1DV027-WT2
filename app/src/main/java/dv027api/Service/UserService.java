package dv027api.Service;

import dv027api.Model.User;
import dv027api.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private UserRepository userRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
  }

  public Boolean registerUser (String username, String password) {
    if (userRepository.findByUsername(username).isPresent()) {
      return false;
    }

    String saltedAndHashedPassword = bCryptPasswordEncoder.encode(password);
    User newUser = new User(username, saltedAndHashedPassword);
    userRepository.save(newUser);
    return true;
  }
}
