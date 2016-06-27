package com.noname.server.factory;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.noname.server.domain.entity.Credential;
import com.noname.server.domain.entity.Hero;
import com.noname.server.domain.entity.HeroSkill;
import com.noname.server.domain.entity.Skill;
import com.noname.server.util.HeroUtils;

/**
 * Created by lacau on 24/02/16.
 */
public final class HeroFactory {

    private static final int START_LEVEL = 1;

    private static final int INITIAL_STR = 5;

    private static final int INITIAL_DEX = 5;

    private static final int INITIAL_STAMINA = 100;

    private HeroFactory() {
        throw new IllegalStateException("HeroFactory class shouldn't be instantiated!");
    }

    public static Hero getNewHero(String name, List<Skill> skills, Long authId) {
        Set<HeroSkill> heroSkills = new LinkedHashSet<HeroSkill>();
        Hero hero = new Hero();
        hero.setCredential(new Credential());
        hero.getCredential().setCdId(authId);
        hero.setName(name);
        hero.setLevel(START_LEVEL);
        hero.setHeroSkills(heroSkills);
        hero.setStr(INITIAL_STR);
        hero.setDex(INITIAL_DEX);
        hero.setStamina(INITIAL_STAMINA);
        hero.setHp(HeroUtils.calculateTotalHp(START_LEVEL, INITIAL_STR));
        hero.setExp(0L);

        for(Skill skill : skills)
            heroSkills.add(new HeroSkill(hero, skill, START_LEVEL));

        return hero;
    }
}