package dv027api.Controller;

import dv027api.Service.MovieService;
import dv027api.View.MovieView;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Controller // some other controller? 
public class MovieController {
  private MovieService movieService;
  private MovieView movieView;
  

  public MovieController (MovieService movieService, MovieView movieView) {
    this.movieService = movieService;
    this.movieView = movieView;
    System.out.println("MovieController constructor is running!");
    this.greeting();
  }

  public void greeting() {
    System.out.println("Hi from Controller-class!");
    // movieService.greeting();
    // movieView.greeting();
}
}
