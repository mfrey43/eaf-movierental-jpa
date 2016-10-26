package ch.fhnw.edu.rental.persistence.impl;

import java.util.List;

import ch.fhnw.edu.rental.model.Movie;
import org.springframework.stereotype.Repository;

import ch.fhnw.edu.rental.model.Rental;
import ch.fhnw.edu.rental.model.User;
import ch.fhnw.edu.rental.persistence.RentalRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class JpaRentalRepository implements RentalRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Rental findOne(Long id) {
		return em.find(Rental.class, id);
	}

	@Override
	public List<Rental> findAll() {
		TypedQuery<Rental> q = em.createNamedQuery("rental.all", Rental.class);
		return q.getResultList();
	}

	@Override
	public Rental save(Rental entity) {
		return em.merge(entity);
	}

	@Override
	public void delete(Long id) {
		delete(findOne(id));
	}

	@Override
	public void delete(Rental entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@Override
	public boolean exists(Long id) {
        return findOne(id) != null;
	}

	@Override
	public long count() {
        return em.createNamedQuery("rental.count", Long.class)
                .getSingleResult();
	}

	@Override
	public List<Rental> findByUser(User user) {
		return user.getRentals();
	}

}
