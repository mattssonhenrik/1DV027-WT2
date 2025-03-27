package dv027api.DTO;

public class UserResponse {
  private boolean success;
  private String message;
  private String jwtToken; 

  public UserResponse(Boolean success, String message, String jwtToken) {
    this.success = success;
    this.message = message;
    this.jwtToken = jwtToken;
  }
  public boolean isSuccess() {
    return success;
  }

  public String getMessage() {
    return message;
  }

  public String getToken() {
    return jwtToken;
  }
}
