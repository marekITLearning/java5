package sk.itlearning.java5.pers.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import sk.itlearning.java5.model.MovieRequest;
import sk.itlearning.java5.pers.entity.Title;

@Stateful
public class TitleService {

	@PersistenceContext(unitName = "APP_DB")
	private EntityManager em;

	public Title find(String id) {
		return em.find(Title.class, id);
	}

	public List<Title> getMovieByRequestParams(MovieRequest request) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Title> q = cb.createQuery(Title.class);
		Root<Title> root = q.from(Title.class);
		String[] order = request.getOrder();
		List<Order> orderList = new ArrayList<>();
		if (request.getOrder() != null) {
			for (String o : order) {
				if (Title.F_primarytitle.equals(o)) {
					orderList.add(request.getAsc() ? cb.asc(root.get(Title.F_primarytitle))
							: cb.desc(root.get(Title.F_primarytitle)));
				}
				if (Title.F_startyear.equals(o)) {
					orderList.add(request.getAsc() ? cb.asc(root.get(Title.F_startyear))
							: cb.desc(root.get(Title.F_startyear)));
				}
			}
		}
		if (orderList.size() == 0) {
			orderList.add(request.getAsc() ? cb.asc(root.get(Title.F_tconst)) : cb.desc(root.get(Title.F_tconst)));
		}
		q.select(root).orderBy(orderList);

		Predicate titleFilter = null;
		if (request.getTitle() != null) {
			titleFilter = cb.like(root.get(Title.F_primarytitle), "%" + request.getTitle() + "%");
		}
		if (titleFilter != null) {
			q.where(cb.and(titleFilter));
		}
		int page = (request.getPage() - 1 < 0) ? 0 : request.getPage() - 1;
		int offset = (page) * request.getPageSize();
		List<Title> list = em.createQuery(q).setFirstResult(offset).setMaxResults(request.getPageSize())
				.getResultList();
		return list;
	}
	
	public void deleteMovie(String primaryKey) {
		Title movie = em.find(Title.class, primaryKey);
		em.remove(movie);
	}

}
