package com.noname.server.converter;

import com.noname.server.domain.entity.Profile;
import com.noname.server.json.ProfileOut;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 22/02/16.
 */
@Component
public class ProfileConverter {

    public ProfileOut convert(Profile profile) {
        ProfileOut profileOut = new ProfileOut();
        profileOut.setBattles(profile.getBattles());
        profileOut.setDies(profile.getDies());
        profileOut.setKills(profile.getKills());
        profileOut.setLooses(profile.getLooses());
        profileOut.setWins(profile.getWins());

        return profileOut;
    }
}