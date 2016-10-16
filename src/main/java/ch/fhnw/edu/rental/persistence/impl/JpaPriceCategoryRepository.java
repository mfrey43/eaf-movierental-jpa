package ch.fhnw.edu.rental.persistence.impl;

import java.util.List;

import ch.fhnw.edu.rental.model.Movie;
import org.springframework.stereotype.Repository;

import ch.fhnw.edu.rental.model.PriceCategory;
import ch.fhnw.edu.rental.persistence.PriceCategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class JpaPriceCategoryRepository implements PriceCategoryRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public PriceCategory findOne(Long id) {
		return em.find(PriceCategory.class, id);
	}

	@Override
	public List<PriceCategory> findAll() {
		TypedQuery<PriceCategory> q = em.createQuery("SELECT pc FROM PriceCategory pc", PriceCategory.class);
		return q.getResultList();
	}

	@Override
	public PriceCategory save(PriceCategory entity) {
		return em.merge(entity);
	}

	@Override
	public void delete(Long id) {
		delete(findOne(id));
	}

	@Override
	public void delete(PriceCategory entity) {
		em.remove(entity);
	}

	@Override
	public boolean exists(Long id) {
		TypedQuery<Long> q = em.createQuery(
				"SELECT COUNT(pc) FROM PriceCategory pc where pc.id = :id", Long.class);
		q.setParameter("id", id);
		return q.getSingleResult() > 0;
	}

	@Override
	public long count() {
		return em.createQuery("SELECT COUNT(pc) FROM PriceCategory pc", Long.class)
				.getSingleResult();
	}


}
