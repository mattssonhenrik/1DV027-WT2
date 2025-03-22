package dv027api.View;

import org.springframework.stereotype.Component;

@Component
public class BookView {
  public BookView() {
    this.greeting();
  }
  public void greeting() {
    System.out.println("Hi from BookView-class!");
  }
}
