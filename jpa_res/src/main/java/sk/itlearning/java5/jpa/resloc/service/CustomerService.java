package sk.itlearning.java5.jpa.resloc.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import sk.itlearning.java5.jpa.resloc.model.Customer;

public class CustomerService {

	private static EntityManagerFactory emFactory;

	static {
		init();
	}

	private static void init() {
		if (emFactory == null) {
			emFactory = Persistence.createEntityManagerFactory("APP_DB");
		}
	}

	public static List<Customer> findAll() {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> q = cb.createQuery(Customer.class);
		Root<Customer> rootEntity = q.from(Customer.class);
		q.select(rootEntity);
		List<Customer> result = em.createQuery(q).getResultList();
		em.getTransaction().commit();
		return result;
	}

	public static void create(Customer entity) {
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
		entity.setLastModified(new Date());
		em.persist(entity);	
		em.getTransaction().commit();
	}
	
}
