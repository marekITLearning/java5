package sk.itlearning.java5.jpa.resloc.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import sk.itlearning.java5.jpa.resloc.model.Customer;

@Stateful
public class CustomerService {

	@PersistenceContext(unitName="APP_DB")
	private EntityManager em;

	public List<Customer> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Customer> q = cb.createQuery(Customer.class);
		Root<Customer> rootEntity = q.from(Customer.class);
		q.select(rootEntity);
		List<Customer> result = em.createQuery(q).getResultList();
		return result;
	}

	public void create(Customer entity) {
		entity.setLastModified(new Date());
		em.persist(entity);	
	}
	
}