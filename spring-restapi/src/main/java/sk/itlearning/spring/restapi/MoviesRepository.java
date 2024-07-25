package sk.itlearning.spring.restapi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Title, String> {
	
	Page<Title> findByPrimarytitleContainingIgnoreCase(String pt, Pageable pageable);

}
