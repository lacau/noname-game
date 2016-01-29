package com.noname.service;

import com.noname.entity.Hero;
import com.noname.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lacau on 29/01/16.
 */
@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public Hero findHero(Long cdId) {
        return heroRepository.find(cdId);
    }
}
