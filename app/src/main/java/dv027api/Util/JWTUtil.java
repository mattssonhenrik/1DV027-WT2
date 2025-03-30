package dv027api.Util;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Utility class for generating and validating JSON Web Tokens (JWTs).
 */
@Component
public class JWTUtil {

  private SecretKey key;
  private Long expirationMillis; // This is long becaues if we (not likely) want to set it to more than 24
                                 // days.

  /**
   * Initializes the utility with the secret key and expiration duration.
   *
   * @param secret           the secret key from environment (.env or properties)
   * @param expirationMillis token validity duration in milliseconds
   */
  public JWTUtil(@Value("${jwt.secret}") String secret,
      @Value("${jwt.expiration}") long expirationMillis) {
    this.key = Keys.hmacShaKeyFor(secret.getBytes());
    this.expirationMillis = expirationMillis;
  }

  /**
   * Generates a signed JWT for the given user.
   *
   * @param username the username to include in the token
   * @param userId   the user ID to set as the subject
   * @return a signed JWT as a string
   */
  public String generateToken(String username, Integer userId) {
    return Jwts.builder()
        .subject(userId.toString())
        .claim("username", username)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + expirationMillis))
        .signWith(key, SIG.HS256)
        .compact();
  }

  /**
   * Parses and verifies the given JWT.
   *
   * @param token the token to parse
   * @return the extracted claims
   * @throws io.jsonwebtoken.JwtException if the token is invalid or expired
   */
  public Claims parseToken(String token) {
    return Jwts.parser()
        .verifyWith(key)
        .build()
        .parseSignedClaims(token)
        .getPayload();
  }
}
