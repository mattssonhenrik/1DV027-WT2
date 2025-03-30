package dv027api.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * Configures Spring Security to allow all requests and disables CSRF
 * protection.
 * Required to run the app without authentication on HTTP endpoints.
 */
@Configuration
public class SecurityConfig {
  /**
   * Defines a security filter chain that disables CSRF and permits all requests.
   *
   * @param http the HttpSecurity instance
   * @return the configured SecurityFilterChain
   * @throws Exception if configuration fails
   */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll())
        .build();
  }
}
