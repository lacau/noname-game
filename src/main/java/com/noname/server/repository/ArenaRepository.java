package com.noname.server.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.noname.server.entity.Arena;
import com.noname.server.entity.Hero;
import com.noname.server.entity.HeroArena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lacau on 08/05/2016.
 */
@Repository
public class ArenaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private HeroArenaRepository heroArenaRepository;

    public Arena findByHeroLevel(Integer heroLevel) {
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT arena FROM Arena arena ");
        hql.append("WHERE arena.level <= :heroLevel ");
        hql.append("ORDER BY arena.level desc");

        final TypedQuery<Arena> query = entityManager.createQuery(hql.toString(), Arena.class);
        query.setParameter("heroLevel", heroLevel);
        query.setMaxResults(1);

        try {
            return query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean enter(Arena arena, Long heroId) {
        HeroArena heroArena = new HeroArena();
        heroArena.setArena(arena);
        heroArena.setHero(new Hero());
        heroArena.getHero().setCdId(heroId);

        try {
            heroArenaRepository.insert(heroArena);
        } catch(RuntimeException e) {
            return false;
        }

        return true;
    }
}