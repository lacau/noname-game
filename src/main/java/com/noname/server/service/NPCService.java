package com.noname.server.service;

import java.util.List;
import java.util.Random;

import com.noname.server.converter.NPCConverter;
import com.noname.server.enums.NPCType;
import com.noname.server.exception.InternalServerErrorException;
import com.noname.server.exception.ResponseException;
import com.noname.server.json.NPCOut;
import com.noname.server.util.MonsterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lacau on 22/04/16.
 */
@Service
public class NPCService {

    private static final Random RANDOM = new Random();

    private static final int LEVEL_RANGE = 8;

    @Autowired
    private NPCConverter npcConverter;

    @Autowired
    private HeroService heroService;

    public List<NPCOut> listRandomNPC(Long heroId, Long credentialId) throws ResponseException {
        final Integer heroLevel = heroService.findHeroLevelById(heroId, credentialId);
        List<NPCType> monsters;
        try {
            monsters = MonsterUtils.findMonster();
        } catch(InterruptedException e) {
            throw new InternalServerErrorException();
        }

        final List<NPCOut> listNPCOut = npcConverter.convert(monsters);
        return randomizeLvl(listNPCOut, heroLevel);
    }

    private List<NPCOut> randomizeLvl(List<NPCOut> listNPCOut, Integer heroLevel) {
        for(NPCOut npc : listNPCOut) {
            RANDOM.setSeed(RANDOM.nextLong());
            final int rand = RANDOM.nextInt(LEVEL_RANGE);
            if(rand == 0)
                npc.setLevel(heroLevel);
            else
                npc.setLevel(rand > 3 ? heroLevel + rand / 2 : heroLevel - rand / 2);

            if(npc.getLevel() <= 0)
                npc.setLevel(1);
        }

        return listNPCOut;
    }
}