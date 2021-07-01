package sk.itlearning.java5.pers.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
		q.select(root).orderBy(cb.asc(root.get(Title.F_primarytitle)));
		List<Title> list = em.createQuery(q).setMaxResults(100).getResultList();
		return list;
	}

}
