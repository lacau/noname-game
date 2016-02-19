package com.noname.server.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(Profile profile) {
        entityManager.persist(profile);
    }
}