package dv027api.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.server.WebGraphQlInterceptor;
import org.springframework.graphql.server.WebGraphQlRequest;
import org.springframework.graphql.server.WebGraphQlResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;

/**
 * Intercepts GraphQL requests and applies JWT-based authentication
 * for mutations that modify book data (add, update, delete).
 */
@Component
public class AuthInterceptor implements WebGraphQlInterceptor {

  @Autowired
  private JWTUtil jwtUtil;

  /**
   * Intercepts incoming GraphQL requests. Only enforces JWT validation
   * for sensitive mutations: addBook, updateBook, deleteBook.
   *
   * @param request the incoming GraphQL request
   * @param chain   the request processing chain
   * @return a Mono that either proceeds or throws an error if JWT is invalid
   */
  @Override
  public Mono<WebGraphQlResponse> intercept(WebGraphQlRequest request, Chain chain) {
    String document = request.getDocument();

    if (!(document.contains("addBook") || document.contains("updateBook") || document.contains("deleteBook"))) {
      return chain.next(request);
    }

    HttpHeaders headers = request.getHeaders();
    String authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);

    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      return Mono
          .error(new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Missing or invalid Authorization header"));
    }

    String token = authHeader.substring(7); // Removing 'Bearer 'and extracting whtas after
    try {
      jwtUtil.parseToken(token);
      return chain.next(request);
    } catch (ExpiredJwtException e) {
      return Mono.error(
          new ResponseStatusException(HttpStatus.UNAUTHORIZED, "JWT expired at: " + e.getClaims().getExpiration()));
    } catch (JwtException e) {
      return Mono.error(
          new ResponseStatusException(HttpStatus.UNAUTHORIZED, "JWT is invalid or corrupted: " + e.getMessage()));
    }
  }
}
