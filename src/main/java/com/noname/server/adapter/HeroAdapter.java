package com.noname.server.adapter;

import java.util.ArrayList;
import java.util.List;

import com.noname.server.entity.Hero;
import com.noname.server.entity.HeroItem;
import com.noname.server.entity.HeroSkill;
import com.noname.server.json.HeroOut;
import com.noname.server.json.ItemOut;
import com.noname.server.json.SkillOut;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 12/02/16.
 */
@Component
public class HeroAdapter {

    public HeroOut adapt(Hero hero) {
        HeroOut heroOut = new HeroOut();
        heroOut.setId(hero.getCdId());
        heroOut.setName(hero.getName());
        heroOut.setLevel(hero.getLevel());

        if(hero.getHeroSkills() != null) {
            List<SkillOut> skills = new ArrayList<SkillOut>();
            for(HeroSkill hs : hero.getHeroSkills()) {
                SkillOut skill = new SkillOut();
                skill.setName(hs.getSkill().getName());
                skill.setDescription(hs.getSkill().getDescription());
                skill.setPower(hs.getSkill().getPower());
                skill.setLevel(hs.getLevel());
                skills.add(skill);
            }
            heroOut.setSkills(skills);
        }

        if(hero.getHeroItems() != null) {
            List<ItemOut> items = new ArrayList<ItemOut>();
            for(HeroItem hi : hero.getHeroItems()) {
                ItemOut item = new ItemOut();
                item.setName(hi.getItem().getName());
                item.setDescription(hi.getItem().getDescription());
                items.add(item);
            }
            heroOut.setItems(items);
        }

        return heroOut;
    }

    public List<HeroOut> adapt(List<Hero> heros) {
        List<HeroOut> listHero = new ArrayList<HeroOut>();
        for(Hero h : heros)
            listHero.add(adapt(h));

        return listHero;
    }
}