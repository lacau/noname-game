package com.noname.server.adapter;

import java.util.ArrayList;
import java.util.List;

import com.noname.server.entity.HeroAchievement;
import com.noname.server.json.AchievementOut;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 22/02/16.
 */
@Component
public class AchievementAdapter {

    public AchievementOut adapt(HeroAchievement heroAchievement) {
        AchievementOut achievementOut = new AchievementOut();
        achievementOut.setName(heroAchievement.getAchievement().getName());
        achievementOut.setDescription(heroAchievement.getAchievement().getDescription());

        return achievementOut;
    }

    public List<AchievementOut> adapt(List<HeroAchievement> achievements) {
        List<AchievementOut> listAchievement = new ArrayList<AchievementOut>();
        for(HeroAchievement a : achievements)
            listAchievement.add(adapt(a));

        return listAchievement;
    }
}