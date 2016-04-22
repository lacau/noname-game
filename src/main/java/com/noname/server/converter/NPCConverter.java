package com.noname.server.converter;

import java.util.ArrayList;
import java.util.List;

import com.noname.server.enums.NPCType;
import com.noname.server.json.NPCOut;
import org.springframework.stereotype.Component;

/**
 * Created by lacau on 22/04/16.
 */
@Component
public class NPCConverter {

    public List<NPCOut> convert(List<NPCType> listNPCType) {
        List<NPCOut> listNPCOut = new ArrayList<NPCOut>();
        for(NPCType type : listNPCType) {
            final NPCOut npcOut = new NPCOut();
            npcOut.setName(type.name());
            npcOut.setType(type.name());
            npcOut.setLvl(1);
            listNPCOut.add(npcOut);
        }

        return listNPCOut;
    }
}