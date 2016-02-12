package com.noname.server.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.noname.server.entity.Credential;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lacau on 12/02/16.
 */
@Repository
public class CredentialRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Long findCountByLogin(String login) {
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT count(credential.id) FROM Credential credential ");
        hql.append("WHERE credential.login = :login");

        final TypedQuery<Long> query = entityManager.createQuery(hql.toString(), Long.class);
        query.setParameter("login", login);

        return query.getSingleResult();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(Credential credential) {
        entityManager.persist(credential);
    }
}
