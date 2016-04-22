package com.noname.server.service;

import java.util.List;

import com.noname.server.converter.AchievementConverter;
import com.noname.server.converter.HeroBasicConverter;
import com.noname.server.converter.HeroConverter;
import com.noname.server.converter.ProfileConverter;
import com.noname.server.entity.Hero;
import com.noname.server.entity.Profile;
import com.noname.server.entity.Skill;
import com.noname.server.exception.HeroNotFoundException;
import com.noname.server.exception.InternalServerErrorException;
import com.noname.server.exception.ResourceAlreadyExistsException;
import com.noname.server.exception.ResponseException;
import com.noname.server.factory.HeroFactory;
import com.noname.server.json.AchievementOut;
import com.noname.server.json.HeroIn;
import com.noname.server.json.HeroOut;
import com.noname.server.json.ProfileOut;
import com.noname.server.repository.AchievementRepository;
import com.noname.server.repository.HeroRepository;
import com.noname.server.repository.ProfileRepository;
import com.noname.server.repository.SkillRepository;
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
    private SkillRepository skillRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AchievementRepository achievementRepository;

    @Autowired
    private HeroConverter heroConverter;

    @Autowired
    private HeroBasicConverter heroBasicConverter;

    @Autowired
    private ProfileConverter profileConverter;

    @Autowired
    private AchievementConverter achievementConverter;

    public HeroOut findHeroById(Long cdId, Long credentialId) throws ResponseException {
        final Hero hero = heroRepository.findById(cdId, credentialId);
        if(hero == null)
            throw new HeroNotFoundException();

        return heroConverter.convert(hero);
    }

    public HeroOut findHeroByName(String name) throws ResponseException {
        final Hero hero = heroRepository.findByName(name);
        if(hero == null)
            throw new HeroNotFoundException();

        return heroBasicConverter.convert(hero);
    }

    public Integer findHeroLevelById(Long cdId, Long credentialId) throws ResponseException {
        final Integer level = heroRepository.findHeroLevelById(cdId, credentialId);
        if(level == null)
            throw new InternalServerErrorException();

        return level;
    }

    public List<HeroOut> listHero(Long credentialId) {
        return heroBasicConverter.convert(heroRepository.listHero(credentialId));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public HeroOut createHero(HeroIn heroIn, Long authId) throws ResponseException {
        final Long countByName = heroRepository.findCountByName(heroIn.getName());
        if(countByName != 0)
            throw new ResourceAlreadyExistsException();

        final List<Skill> skills = skillRepository.listAll();
        Hero hero = HeroFactory.getNewHero(heroIn.getName(), skills, authId);

        heroRepository.insert(hero);

        Profile profile = new Profile();
        profile.setHero(hero);

        profileRepository.insert(profile);

        return heroBasicConverter.convert(hero);
    }

    public ProfileOut findProfileByHeroId(Long cdId) throws ResponseException {
        final Profile profile = profileRepository.findByHeroId(cdId);
        if(profile == null)
            throw new HeroNotFoundException();

        return profileConverter.convert(profile);
    }

    public List<AchievementOut> listAchievementByHeroId(Long heroId) {
        return achievementConverter.convert(achievementRepository.listByHeroId(heroId));
    }
}