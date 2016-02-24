package com.noname.server.factory;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.noname.server.entity.Credential;
import com.noname.server.entity.Hero;
import com.noname.server.entity.HeroSkill;
import com.noname.server.entity.Skill;
import com.noname.server.util.MathUtils;

/**
 * Created by lacau on 24/02/16.
 */
public class HeroFactory {

    private static final int startLevel = 1;

    private static final int initialStr = 5;

    private static final int initialStamina = 100;

    private HeroFactory() {
        throw new IllegalStateException("HeroFactory class shouldn't be instantiated!");
    }

    public static Hero getNewHero(String name, List<Skill> skills, Long authId) {
        Set<HeroSkill> heroSkills = new LinkedHashSet<HeroSkill>();
        Hero hero = new Hero();
        hero.setCredential(new Credential());
        hero.getCredential().setCdId(authId);
        hero.setName(name);
        hero.setLevel(startLevel);
        hero.setHeroSkills(heroSkills);
        hero.setStr(initialStr);
        hero.setStamina(initialStamina);
        hero.setHp(MathUtils.calculateTotalHp(startLevel, initialStr));

        for(Skill skill : skills)
            heroSkills.add(new HeroSkill(hero, skill, startLevel));

        return hero;
    }
}