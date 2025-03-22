package dv027api.Repository;
//https://youtu.be/-Fe0zk-F4OA?si=3s_kHtpPjtsRCrfa&t=12774

import dv027api.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Spring automatically generate the implementation for BookRepository at runtime so we do not need to make it, thats why we @Repository annotation works here but not in the ServiceInterface, that we need to make a concrete class implementation for.
@Repository
public interface BookRepository extends JpaRepository <Book, String> {
  
}
