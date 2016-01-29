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
    public Hero find(Long id) {
        return entityManager.find(Hero.class, id);
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
