package com.noname.server.converter;

import java.util.ArrayList;
import java.util.List;

import com.noname.server.domain.entity.HeroAchievement;
import com.noname.server.json.AchievementOut;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 22/02/16.
 */
@Component
public class AchievementConverter {

    public AchievementOut convert(HeroAchievement heroAchievement) {
        AchievementOut achievementOut = new AchievementOut();
        achievementOut.setName(heroAchievement.getAchievement().getName());
        achievementOut.setDescription(heroAchievement.getAchievement().getDescription());

        return achievementOut;
    }

    public List<AchievementOut> convert(List<HeroAchievement> achievements) {
        List<AchievementOut> listAchievement = new ArrayList<AchievementOut>();
        for(HeroAchievement a : achievements)
            listAchievement.add(convert(a));

        return listAchievement;
    }
}