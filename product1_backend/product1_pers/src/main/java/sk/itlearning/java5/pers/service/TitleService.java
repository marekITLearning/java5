package sk.itlearning.java5.pers.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

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
			}
		}
		if (orderList.size() == 0) {
			orderList.add(request.getAsc() ? cb.asc(root.get(Title.F_primarytitle))
					: cb.desc(root.get(Title.F_primarytitle)));
		}
		q.select(root).orderBy(orderList);
		int page = (request.getPage() - 1 < 0) ? 0 : request.getPage() - 1; 
		int offset = (page)* request.getPageSize();
		List<Title> list = em.createQuery(q).setFirstResult(offset).setMaxResults(request.getPageSize())
				.getResultList();
		return list;
	}

}
