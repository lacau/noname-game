package com.noname.server.repository;

import java.util.ArrayList;
import java.util.List;
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

    public Hero findById(Long id, Long credentialId) {
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT hero FROM Hero hero ");
        hql.append("JOIN FETCH hero.heroSkills heroSkills ");
        hql.append("JOIN FETCH heroSkills.skill skill ");
        hql.append("LEFT JOIN FETCH hero.heroItems heroItems ");
        hql.append("LEFT JOIN FETCH heroItems.item item ");
        hql.append("JOIN hero.credential credential ");
        hql.append("WHERE credential.id = :credentialId ");
        hql.append("AND hero.id = :heroId");

        final TypedQuery<Hero> query = entityManager.createQuery(hql.toString(), Hero.class);
        query.setParameter("credentialId", credentialId);
        query.setParameter("heroId", id);

        try {
            return query.getSingleResult();
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

    public Long findCountByName(String name) {
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT count(hero.id) FROM Hero hero ");
        hql.append("WHERE hero.name = :name");

        final TypedQuery<Long> query = entityManager.createQuery(hql.toString(), Long.class);
        query.setParameter("name", name);

        return query.getSingleResult();
    }

    public List<Hero> listHero(Long credentialId) {
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT hero FROM Hero hero ");
        hql.append("JOIN hero.credential credential ");
        hql.append("WHERE credential.id = :credentialId");

        final TypedQuery<Hero> query = entityManager.createQuery(hql.toString(), Hero.class);
        query.setParameter("credentialId", credentialId);

        try {
            return query.getResultList();
        } catch(NoResultException e) {
            return new ArrayList<Hero>();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(Hero hero) {
        entityManager.persist(hero);
    }
}