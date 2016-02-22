package com.noname.server.adapter;

import java.util.ArrayList;
import java.util.List;

import com.noname.server.entity.Skill;
import com.noname.server.json.SkillOut;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 22/02/16.
 */
@Component
public class SkillAdapter {

    public SkillOut adapt(Skill skill) {
        SkillOut skillOut = new SkillOut();
        skillOut.setName(skill.getName());
        skillOut.setDescription(skill.getDescription());
        skillOut.setPower(skill.getPower());

        return skillOut;
    }

    public List<SkillOut> adapt(List<Skill> skills) {
        List<SkillOut> listSkill = new ArrayList<SkillOut>();
        for(Skill s : skills)
            listSkill.add(adapt(s));

        return listSkill;
    }
}