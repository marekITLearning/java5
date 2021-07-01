package sk.itlearning.java5.pers.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.eclipse.persistence.config.CacheUsage;
import org.eclipse.persistence.config.QueryHints;

import sk.itlearning.java5.pers.entity.Rating;

@Stateful
public class RatingService {

	@PersistenceContext(unitName = "APP_DB")
	private EntityManager em;

	public Rating find(long id) {
		return em.find(Rating.class, id);
	}

	public void create(Rating entity) {
		em.persist(entity);
		em.flush();
	}

	public List<Rating> getAll() {
		em.getEntityManagerFactory().getCache().evictAll();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Rating> q = cb.createQuery(Rating.class);
		Root<Rating> root = q.from(Rating.class);
		List<Predicate> conditions = new ArrayList<>();
		conditions.add(
				cb.and(cb.greaterThan(root.get("averagerating"), 10.0f), cb.greaterThan(root.get("numvotes"), 100)));
		q.select(root);
		return em.createQuery(q).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Rating> getTop(float averagerating) {
		em.clear();
		Query query = em.createQuery(
				"SELECT r, t FROM Rating r, Title t WHERE r.tconst = t.tconst and r.averagerating > :averagerating and t.startyear >= 2000 and r.numvotes > 100");
		query.setParameter("averagerating", averagerating);
		query.setHint(QueryHints.CACHE_USAGE, CacheUsage.NoCache);
		return query.getResultList();
	}

	public void update(Rating rating) {
		if (!em.contains((Rating) rating)) {
			em.merge((Rating) rating);
		}
		em.flush();
	}

	public void delete(long id) {
		Rating customer = find(id);
		if (!em.contains((Rating) customer)) {
			customer = em.merge((Rating) customer);
		}
		em.remove((Rating) customer);
		em.flush();
	}

}
