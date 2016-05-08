package com.noname.server.service;

import com.noname.server.entity.Arena;
import com.noname.server.exception.ArenaNotFoundException;
import com.noname.server.exception.InternalServerErrorException;
import com.noname.server.exception.ResponseException;
import com.noname.server.repository.ArenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lacau on 08/05/2016.
 */
@Service
public class ArenaService {

    @Autowired
    private HeroService heroService;

    @Autowired
    private ArenaRepository arenaRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void enter(Long heroId, Long credentialId) throws ResponseException {
        Integer heroLevel = heroService.findHeroLevelById(heroId, credentialId);
        Arena arena = arenaRepository.findByHeroLevel(heroLevel);
        if(arena == null)
            throw new ArenaNotFoundException();

        boolean entered = arenaRepository.enter(arena, heroId);
        if(!entered)
            throw new InternalServerErrorException();
    }
}