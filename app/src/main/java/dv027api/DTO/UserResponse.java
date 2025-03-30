package dv027api.DTO;

/**
 * Data Transfer Object for responding to user-related mutations
 * like login and registration.
 */
public class UserResponse {
  private boolean success;
  private String message;
  private String jwtToken;

  /**
   * Constructs a new UserResponse.
   *
   * @param success  whether the operation was successful
   * @param message  a message describing the outcome
   * @param jwtToken the generated JWT (null if not applicable)
   */
  public UserResponse(Boolean success, String message, String jwtToken) {
    this.success = success;
    this.message = message;
    this.jwtToken = jwtToken;
  }

  /**
   * @return true if the operation was successful
   */
  public boolean isSuccess() {
    return success;
  }

  /**
   * @return a message describing the outcome
   */
  public String getMessage() {
    return message;
  }

  /**
   * @return the JWT token (may be null if not issued)
   */
  public String getToken() {
    return jwtToken;
  }
}
