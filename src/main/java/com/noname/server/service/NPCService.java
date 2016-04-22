package com.noname.server.service;

import java.util.List;

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

    @Autowired
    private NPCConverter npcConverter;

    public List<NPCOut> listRandomNPC() throws ResponseException {
        try {
            final List<NPCType> monsters = MonsterUtils.findMonster();
            return npcConverter.convert(monsters);
        } catch(InterruptedException e) {
            throw new InternalServerErrorException();
        }
    }
}