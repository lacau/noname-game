package com.noname.server.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.noname.server.entity.Hero;
import com.noname.server.entity.HeroAchievement;
import org.springframework.stereotype.Repository;

/**
 * Created by lacau on 22/02/16.
 */
@Repository
public class AchievementRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<HeroAchievement> listByHeroId(Long heroId) {
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT heroAchievement FROM HeroAchievement heroAchievement ");
        hql.append("JOIN FETCH heroAchievement.achievement ");
        hql.append("WHERE heroAchievement.hero = :hero");

        final TypedQuery<HeroAchievement> query = entityManager.createQuery(hql.toString(), HeroAchievement.class);
        Hero hero = new Hero();
        hero.setCdId(heroId);
        query.setParameter("hero", hero);

        try {
            return query.getResultList();
        } catch(NoResultException e) {
            return new ArrayList<HeroAchievement>();
        }
    }
}