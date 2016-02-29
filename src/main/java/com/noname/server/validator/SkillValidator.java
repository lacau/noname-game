package com.noname.server.validator;

import java.util.List;

import com.noname.server.entity.Skill;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 29/02/16.
 */
@Component
public class SkillValidator {

    public boolean isSkillsValidForHeroLevel(int heroLevel, List<Skill> skills) {
        return false;
    }
}