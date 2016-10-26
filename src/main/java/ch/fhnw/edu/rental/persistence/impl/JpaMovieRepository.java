package ch.fhnw.edu.rental.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ch.fhnw.edu.rental.model.Movie;
import ch.fhnw.edu.rental.persistence.MovieRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class JpaMovieRepository implements MovieRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Movie findOne(Long id) {
		return em.find(Movie.class, id);
	}

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> q = em.createQuery("SELECT m FROM Movie m", Movie.class);
		return q.getResultList();
	}

	@Override
	public Movie save(Movie entity) {
		return em.merge(entity);
	}

	@Override
	public void delete(Long id) {
		delete(findOne(id));
	}

	@Override
	public void delete(Movie entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@Override
	public boolean exists(Long id) {
		TypedQuery<Long> q = em.createQuery(
				"SELECT COUNT(m) FROM Movie m where m.id = :id", Long.class);
		q.setParameter("id", id);
		return q.getSingleResult() > 0;
	}

	@Override
	public long count() {
		return em.createQuery("SELECT COUNT(m) FROM Movie m", Long.class)
				.getSingleResult();
	}

	@Override
	public List<Movie> findByTitle(String title) {
		TypedQuery<Movie> q = em.createQuery(
				"SELECT m FROM Movie m WHERE m.title = :title",
				Movie.class);
		q.setParameter("title", title);
		return q.getResultList();
	}

}
