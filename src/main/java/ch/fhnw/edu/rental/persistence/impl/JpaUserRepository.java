package ch.fhnw.edu.rental.persistence.impl;

import java.util.List;

import ch.fhnw.edu.rental.model.Movie;
import org.springframework.stereotype.Repository;

import ch.fhnw.edu.rental.model.User;
import ch.fhnw.edu.rental.persistence.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> q = em.createNamedQuery("user.all", User.class);
        return q.getResultList();
    }

    @Override
    public User save(User entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(Long id) {
        delete(findOne(id));
    }

    @Override
    public void delete(User entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Override
    public boolean exists(Long id) {
        return findOne(id) != null;
    }

    @Override
    public long count() {
        return em.createNamedQuery("user.count", Long.class)
                .getSingleResult();
    }

    @Override
    public List<User> findByLastName(String lastName) {
        TypedQuery<User> q = em.createNamedQuery(
                "user.byLastName",
                User.class);
        q.setParameter("lastName", lastName);
        return q.getResultList();
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        TypedQuery<User> q = em.createNamedQuery(
                "user.byFirstName",
                User.class);
        q.setParameter("firstName", firstName);
        return q.getResultList();
    }

    @Override
    public List<User> findByEmail(String email) {
        TypedQuery<User> q = em.createNamedQuery(
                "user.byEmail",
                User.class);
        q.setParameter("email", email);
        return q.getResultList();
    }
}
