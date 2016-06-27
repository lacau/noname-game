package com.noname.server.converter;

import java.util.ArrayList;
import java.util.List;

import com.noname.server.domain.entity.Hero;
import com.noname.server.json.HeroOut;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 12/02/16.
 */
@Component
public class HeroBasicConverter {

    public HeroOut convert(Hero hero) {
        HeroOut heroOut = new HeroOut();
        heroOut.setId(hero.getCdId());
        heroOut.setName(hero.getName());
        heroOut.setLevel(hero.getLevel());

        return heroOut;
    }

    public List<HeroOut> convert(List<Hero> heros) {
        List<HeroOut> listHero = new ArrayList<HeroOut>();
        for(Hero h : heros)
            listHero.add(convert(h));

        return listHero;
    }
}