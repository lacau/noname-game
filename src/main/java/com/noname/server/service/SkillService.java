package com.noname.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.noname.server.converter.SkillConverter;
import com.noname.server.entity.Hero;
import com.noname.server.entity.HeroSkill;
import com.noname.server.entity.Skill;
import com.noname.server.enums.SkillType;
import com.noname.server.exception.HeroNotFoundException;
import com.noname.server.exception.InvalidSkillsException;
import com.noname.server.exception.ResponseException;
import com.noname.server.json.SkillIn;
import com.noname.server.json.SkillOut;
import com.noname.server.json.SkillSelectIn;
import com.noname.server.repository.HeroRepository;
import com.noname.server.repository.SkillRepository;
import com.noname.server.validator.SkillValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lacau on 22/02/16.
 */
@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private SkillConverter skillConverter;

    @Autowired
    private SkillValidator skillValidator;

    public List<SkillOut> listSkill() {
        return skillConverter.convert(skillRepository.listAll());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void selectSkills(SkillSelectIn skillSelectIn, Long authId) throws ResponseException {
        final Hero hero = heroRepository.findWithAllSkills(skillSelectIn.getHeroId(), authId);
        if(hero == null)
            throw new HeroNotFoundException();

        final List<SkillType> skillTypes = createListSkillType(skillSelectIn);
        final List<Skill> skills = skillRepository.findByType(skillTypes);

        if(!skillValidator.isSkillsValidForHeroLevel(hero.getLevel(), skills))
            throw new InvalidSkillsException();

        final Set<HeroSkill> heroSkills = hero.getHeroSkills();
        for(HeroSkill heroSkill : heroSkills) {
            heroSkill.setOrder((short) 0);
            if(skills.contains(heroSkill.getSkill())) {
                heroSkill.setSelected(true);
                heroSkill.setOrder(getOrderBySkillType(skillSelectIn, heroSkill.getSkill().getType()));
            }
        }

        skillRepository.update(heroSkills);
    }

    private Short getOrderBySkillType(SkillSelectIn skillSelectIn, SkillType type) {
        for(SkillIn skillIn : skillSelectIn.getListSkill())
            if(skillIn.getType() == type)
                return skillIn.getOrder().shortValue();
        return 0;
    }

    private List<SkillType> createListSkillType(SkillSelectIn skillSelectIn) {
        final List<SkillIn> listSkill = skillSelectIn.getListSkill();
        List<SkillType> types = new ArrayList<SkillType>();
        for(SkillIn skill : listSkill)
            types.add(skill.getType());

        return types;
    }
}