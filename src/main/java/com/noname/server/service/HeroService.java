package com.noname.server.service;

import java.util.List;

import com.noname.server.adapter.HeroAdapter;
import com.noname.server.entity.Credential;
import com.noname.server.entity.Hero;
import com.noname.server.exception.HeroNotFoundException;
import com.noname.server.exception.ResourceAlreadyExistsException;
import com.noname.server.json.HeroIn;
import com.noname.server.json.HeroOut;
import com.noname.server.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lacau on 29/01/16.
 */
@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private HeroAdapter heroAdapter;

    public HeroOut findHeroById(Long cdId, Long credentialId) throws HeroNotFoundException {
        final Hero hero = heroRepository.findById(cdId, credentialId);
        if(hero == null)
            throw new HeroNotFoundException();

        return heroAdapter.adapt(hero);
    }

    public HeroOut findHeroByName(String name) throws HeroNotFoundException {
        final Hero hero = heroRepository.findByName(name);
        if(hero == null)
            throw new HeroNotFoundException();

        return heroAdapter.adapt(hero);
    }

    public List<HeroOut> listHero(Long credentialId) {
        return heroAdapter.adapt(heroRepository.listHero(credentialId));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public HeroOut createHero(HeroIn heroIn, Long authId) throws ResourceAlreadyExistsException {
        final Long countByName = heroRepository.findCountByName(heroIn.getName());
        if(countByName != 0)
            throw new ResourceAlreadyExistsException();

        Hero hero = new Hero();
        hero.setCredential(new Credential());
        hero.getCredential().setCdId(authId);
        hero.setName(heroIn.getName());
        hero.setLevel(1);

        heroRepository.insert(hero);

        return heroAdapter.adapt(hero);
    }
}