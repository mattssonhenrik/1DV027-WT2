package dv027api.Util;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

  private SecretKey key;
  private Long expirationMillis; // This is long becaues if we (not likely) want to set it to more than 24
                                 // days.

  public JWTUtil(@Value("${jwt.secret}") String secret,
      @Value("${jwt.expiration}") long expirationMillis) {
    this.key = Keys.hmacShaKeyFor(secret.getBytes());
    this.expirationMillis = expirationMillis;
  }

  public String generateToken(String username, Integer userId) {
    return Jwts.builder()
        .subject(userId.toString())
        .claim("username", username)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + expirationMillis))
        .signWith(key, SIG.HS256)
        .compact();
  }

  public Claims parseToken(String token) {
    return Jwts.parser()
        .verifyWith(key)
        .build()
        .parseSignedClaims(token)
        .getPayload();
  }
}
