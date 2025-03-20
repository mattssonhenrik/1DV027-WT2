package dv027api.Service;

import org.springframework.stereotype.Service;

import dv027api.Repository.MovieRepository;

@Service
public class MovieServiceImplementation implements MovieService {
  private MovieRepository movieRepository;

  public MovieServiceImplementation(MovieRepository movieRepository){
    this.movieRepository = movieRepository;
    this.greeting();
  }

  public void greeting() {
    System.out.println("Hi from ServiceClass!-class!");
}
}
