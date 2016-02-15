package com.noname.server.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.noname.server.entity.Hero;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lacau on 29/01/16.
 */
@Repository
public class HeroRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Hero findById(Long id) {
        try {
            return entityManager.find(Hero.class, id);
        } catch(NoResultException e) {
            return null;
        }
    }

    public Hero findByName(String name) {
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT hero FROM Hero hero ");
        hql.append("WHERE hero.name = :name");

        final TypedQuery<Hero> query = entityManager.createQuery(hql.toString(), Hero.class);
        query.setParameter("name", name);

        try {
            return query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(Hero hero) {
        entityManager.persist(hero);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Hero hero) {
        entityManager.merge(hero);
    }
}