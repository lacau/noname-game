package com.noname.server.converter;

import java.util.ArrayList;
import java.util.List;

import com.noname.server.domain.entity.Hero;
import com.noname.server.domain.entity.HeroItem;
import com.noname.server.domain.entity.HeroSkill;
import com.noname.server.json.HeroOut;
import com.noname.server.json.ItemOut;
import com.noname.server.json.SkillOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 12/02/16.
 */
@Component
public class HeroConverter {

    @Autowired
    private HeroBasicConverter heroBasicConverter;

    @Autowired
    private SkillConverter skillConverter;

    public HeroOut convert(Hero hero) {
        HeroOut heroOut = heroBasicConverter.convert(hero);
        heroOut.setExp(hero.getExp());
        heroOut.setHp(hero.getHp());
        heroOut.setStamina(hero.getStamina());
        heroOut.setStr(hero.getStr());
        heroOut.setDex(hero.getDex());

        if(hero.getHeroSkills() != null) {
            List<SkillOut> skills = new ArrayList<SkillOut>();
            for(HeroSkill hs : hero.getHeroSkills()) {
                SkillOut skill = skillConverter.convert(hs.getSkill());
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