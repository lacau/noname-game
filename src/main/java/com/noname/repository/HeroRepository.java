package com.noname.repository;

import javax.persistence.*;

import com.noname.entity.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

/**
 * Created by lacau on 29/01/16.
 */
@Repository
public class HeroRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    public Hero findById(Long id) {
        return entityManager.find(Hero.class, id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Hero findByName(String name) {
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT hero FROM Hero hero ");
        hql.append("WHERE hero.name = :name");

        final TypedQuery<Hero> query = entityManager.createQuery(hql.toString(), Hero.class);
        query.setParameter("name", name);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw e;
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
