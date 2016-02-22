package com.noname.server.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.noname.server.entity.Hero;
import com.noname.server.entity.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lacau on 19/02/16.
 */
@Repository
public class ProfileRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Profile findByHeroId(Long heroId) {
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT profile FROM Profile profile ");
        hql.append("WHERE hero = :hero");

        final TypedQuery<Profile> query = entityManager.createQuery(hql.toString(), Profile.class);
        Hero hero = new Hero();
        hero.setCdId(heroId);
        query.setParameter("hero", hero);

        try {
            return query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(Profile profile) {
        entityManager.persist(profile);
    }
}