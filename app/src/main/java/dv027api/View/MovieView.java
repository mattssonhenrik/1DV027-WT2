package dv027api.View;

import org.springframework.stereotype.Component;

@Component
public class MovieView {
  
  public MovieView() {
    this.greeting();
  }

  public void greeting() {
    System.out.println("Hi from MovieView-class!");
}
}

