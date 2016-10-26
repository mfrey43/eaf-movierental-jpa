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
		TypedQuery<Movie> q = em.createNamedQuery("movie.all", Movie.class);
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
		return findOne(id) != null;
	}

	@Override
	public long count() {
		return em.createNamedQuery("movie.count", Long.class)
				.getSingleResult();
	}

	@Override
	public List<Movie> findByTitle(String title) {
		TypedQuery<Movie> q = em.createNamedQuery("movie.byTitle", Movie.class);
		q.setParameter("title", title);
		return q.getResultList();
	}

}
