package dv027api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity  
@Table(name = "movies") 
public class Movie {
  
    @Id
    private Integer id; // Required for JPA entities

}