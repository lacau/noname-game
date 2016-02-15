package com.noname.server.service;

import com.noname.server.entity.Hero;
import com.noname.server.exception.HeroNotFoundException;
import com.noname.server.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lacau on 29/01/16.
 */
@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public Hero findHeroById(Long cdId) throws HeroNotFoundException {
        final Hero hero = heroRepository.findById(cdId);
        if(hero == null)
            throw new HeroNotFoundException();

        return hero;
    }

    public Hero findHeroByName(String name) throws HeroNotFoundException {
        final Hero hero = heroRepository.findByName(name);
        if(hero == null)
            throw new HeroNotFoundException();

        return hero;
    }
}