package com.noname.server.converter;

import java.util.ArrayList;
import java.util.List;

import com.noname.server.domain.entity.Skill;
import com.noname.server.json.SkillOut;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 22/02/16.
 */
@Component
public class SkillConverter {

    public SkillOut convert(Skill skill) {
        SkillOut skillOut = new SkillOut();
        skillOut.setName(skill.getName());
        skillOut.setDescription(skill.getDescription());
        skillOut.setPower(skill.getPower());
        skillOut.setType(skill.getType().name());

        return skillOut;
    }

    public List<SkillOut> convert(List<Skill> skills) {
        List<SkillOut> listSkill = new ArrayList<SkillOut>();
        for(Skill s : skills)
            listSkill.add(convert(s));

        return listSkill;
    }
}