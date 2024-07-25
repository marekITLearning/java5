package sk.itlearning.spring.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapp/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApiController {

	@Autowired
	MoviesRepository mr;

	@PostMapping("/movie")
	public List<Title> getMovies(@RequestBody TitleRequest request) {
		
		request.setPage(request.getPage() < 0 ? 0 : request.getPage());
		request.setPageSize((request.getPageSize() < 1 || request.getPageSize() > 1000) ? 100 : request.getPageSize());
		request.setSortBy((request.getSortBy() == null || request.getSortBy().isBlank()) ? "tconst" : request.getSortBy());

		Pageable pageable = PageRequest.of(request.getPage(), request.getPageSize(),
				Sort.by(request.getSortBy()));

		if (request.getTitleLike() != null) {
			return mr.findByPrimarytitleContainingIgnoreCase(request.getTitleLike(), pageable).getContent();
		} else {
			return mr.findAll(pageable).getContent();
		}

	}

}
