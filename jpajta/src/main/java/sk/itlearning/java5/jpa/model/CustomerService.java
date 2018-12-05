package sk.itlearning.java5.jpa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Stateful
public class CustomerService {

	@PersistenceContext(unitName="APP_DB")
	private EntityManager em;

	public void create(Customer entity) {
		entity.setLastModified(new Date());
		em.persist(entity);
	}

	public List<Customer> read() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> q = cb.createQuery(Customer.class);
		Root<Customer> root = q.from(Customer.class);
		q.select(root);
		List<Customer> result = em.createQuery(q).getResultList();
		return result;
	}

	public void update(Customer customer) {
		customer.setLastModified(new Date());
		if (!em.contains((Customer) customer)) {
			em.merge((Customer) customer);
		}
	}

	public void delete(Customer customer) {
		if (!em.contains((Customer) customer)) {
			customer = em.merge((Customer) customer);
		}
		em.remove((Customer) customer);
	}

	public List<Customer> read(String nameSubstring) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> q = cb.createQuery(Customer.class);
		Root<Customer> root = q.from(Customer.class);
		List<Predicate> conditions = new ArrayList<>();
		if (nameSubstring != null && !nameSubstring.isEmpty()) {
			conditions.add(cb.or(
					cb.like(root.get("firstName"), "%" + nameSubstring + "%"),
					cb.like(root.get("lastName"), "%" + nameSubstring + "%")));
		}
		if (nameSubstring != null && !nameSubstring.isEmpty()) {
			conditions.add(cb.or(
					cb.like(cb.upper(root.get("firstName")), "%" + nameSubstring.toUpperCase() + "%"),
					cb.like(cb.upper(root.get("lastName")), "%" + nameSubstring.toUpperCase() + "%")));
		}
		q.select(root).where(conditions.toArray(new Predicate[] {}));
		q.orderBy(cb.asc(root.get("firstName")));
		List<Customer> result = em.createQuery(q).getResultList();
		return result;
	}
	
	public Customer find(Customer customer) {
		return em.find(Customer.class, customer.getId());
	}

}
