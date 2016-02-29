package com.noname.server.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.noname.server.entity.Skill;
import com.noname.server.enums.SkillType;
import org.springframework.stereotype.Repository;

/**
 * Created by lacau on 29/01/16.
 */
@Repository
public class SkillRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Skill> listAll() {
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT skill FROM Skill skill");

        final TypedQuery<Skill> query = entityManager.createQuery(hql.toString(), Skill.class);

        try {
            return query.getResultList();
        } catch(NoResultException e) {
            return new ArrayList<Skill>();
        }
    }

    public List<Skill> findByType(SkillType... skillTypes) {
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT skill FROM Skill skill ");
        hql.append("WHERE skill.type IN :skillTypes");

        final TypedQuery<Skill> query = entityManager.createQuery(hql.toString(), Skill.class);
        query.setParameter("skillTypes", skillTypes);

        try {
            return query.getResultList();
        } catch(NoResultException e) {
            return new ArrayList<Skill>();
        }
    }
}