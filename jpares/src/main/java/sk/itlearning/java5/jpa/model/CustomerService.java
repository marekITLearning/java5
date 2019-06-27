package sk.itlearning.java5.jpa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomerService {

	private EntityManagerFactory emFactory;

	public CustomerService() {
		if (emFactory == null) {
			emFactory = Persistence.createEntityManagerFactory("APP_DB");
		}
	}

	public void create(Customer entity) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		entity.setLastModified(new Date());
		em.persist(entity);
		em.getTransaction().commit();
	}

	public List<Customer> read() {
		EntityManager em = emFactory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> q = cb.createQuery(Customer.class);
		Root<Customer> root = q.from(Customer.class);
		q.select(root);
		List<Customer> result = em.createQuery(q).getResultList();
		return result;
	}

	public Customer readById(long id) {
		EntityManager em = emFactory.createEntityManager();
		return em.find(Customer.class, id);
	}
	
	public void update(Customer customer) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
//		Customer entity = em.find(Customer.class, customer.getId());
		customer.setLastModified(new Date());
		if (!em.contains((Customer) customer)) {
			em.merge((Customer) customer);
		}
		em.getTransaction().commit();
	}

	public void delete(Customer customer) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		if (!em.contains((Customer) customer)) {
			customer = em.merge((Customer) customer);
		}
		em.remove((Customer) customer);
		em.getTransaction().commit();
	}

	public List<Customer> read(String nameSubstring) {
		EntityManager em = emFactory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> q = cb.createQuery(Customer.class);
		Root<Customer> root = q.from(Customer.class);
		List<Predicate> conditions = new ArrayList<>();
//		if (nameSubstring != null && !nameSubstring.isEmpty()) {
//			conditions.add(cb.or(
//					cb.like(root.get("firstName"), "%" + nameSubstring + "%"),
//					cb.like(root.get("lastName"), "%" + nameSubstring + "%")));
//		}
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
		EntityManager em = emFactory.createEntityManager();
		return em.find(Customer.class, customer.getId());
	}

}
