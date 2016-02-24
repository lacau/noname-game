package com.noname.server.adapter;

import java.util.ArrayList;
import java.util.List;

import com.noname.server.entity.Hero;
import com.noname.server.entity.HeroItem;
import com.noname.server.entity.HeroSkill;
import com.noname.server.json.HeroOut;
import com.noname.server.json.ItemOut;
import com.noname.server.json.SkillOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 12/02/16.
 */
@Component
public class HeroAdapter {

    @Autowired
    private HeroBasicAdapter heroBasicAdapter;

    @Autowired
    private SkillAdapter skillAdapter;

    public HeroOut adapt(Hero hero) {
        HeroOut heroOut = heroBasicAdapter.adapt(hero);

        if(hero.getHeroSkills() != null) {
            List<SkillOut> skills = new ArrayList<SkillOut>();
            for(HeroSkill hs : hero.getHeroSkills()) {
                SkillOut skill = skillAdapter.adapt(hs.getSkill());
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
                item.setAmount(hi.getAmount());
                items.add(item);
            }
            heroOut.setItems(items);
        }

        return heroOut;
    }
}