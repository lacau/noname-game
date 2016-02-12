package com.noname.server.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    private EntityManager entityManager;

    public Long findCountByLogin(String login) {
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT count(credential.id) FROM Credential credential ");
        hql.append("WHERE credential.login = :login");

        final TypedQuery<Long> query = entityManager.createQuery(hql.toString(), Long.class);
        query.setParameter("login", login);

        return query.getSingleResult();
    }

    public Credential findByIdAndToken(Credential credential) {
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT credential FROM Credential credential ");
        hql.append("WHERE credential.cdId = :cdId ");
        hql.append("AND credential.token = :token");

        final TypedQuery<Credential> query = entityManager.createQuery(hql.toString(), Credential.class);
        query.setParameter("cdId", credential.getCdId());
        query.setParameter("token", credential.getToken());

        try {
            return query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    public Credential findByLoginAndPassword(Credential credential) {
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT count(credential.id) FROM Credential credential ");
        hql.append("WHERE credential.login = :login");
        hql.append("WHERE credential.password = :password");

        final TypedQuery<Credential> query = entityManager.createQuery(hql.toString(), Credential.class);
        query.setParameter("login", credential.getLogin());
        query.setParameter("password", credential.getPassword());

        try {
            return query.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(Credential credential) {
        entityManager.persist(credential);
    }
}