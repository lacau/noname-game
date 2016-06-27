package com.noname.server.domain.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.noname.server.domain.entity.HeroArena;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lacau on 08/05/16.
 */
@Repository
public class HeroArenaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(HeroArena heroArena) {
        entityManager.persist(heroArena);
    }
}