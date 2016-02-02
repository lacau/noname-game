package com.noname.server.service;

import com.noname.server.entity.Hero;
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

    public Hero findHeroById(Long cdId) {
        return heroRepository.findById(cdId);
    }

    public Hero findHeroByName(String name) {
        return heroRepository.findByName(name);
    }
}