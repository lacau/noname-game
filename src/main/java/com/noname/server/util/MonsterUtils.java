package com.noname.server.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.noname.server.enums.NPCType;

/**
 * Created by lacau on 24/02/16.
 */
public final class MonsterUtils {

    private static final short MONSTERS_PER_FIND = 5;

    private static final Random RANDOM = new Random();

    private static final int HUNDRED = 100;

    private MonsterUtils() {
        throw new IllegalStateException("MonsterUtils class shouldn't be instantiated!");
    }

    public static List<NPCType> findMonster() throws InterruptedException {
        List<NPCType> listNPC = new ArrayList<NPCType>();

        final NPCType[] values = NPCType.values();
        lb:
        for(int i = 0; i < MONSTERS_PER_FIND; i++) {
            RANDOM.setSeed(RANDOM.nextLong());
            final int rand = RANDOM.nextInt(HUNDRED);
            for(NPCType type : values) {
                if(rand < type.getPercent()) {
                    listNPC.add(type);
                    if(type != NPCType.ZOMBIE) {
                        for(int x = listNPC.size(); x < MONSTERS_PER_FIND; x++) {
                            listNPC.add(NPCType.ZOMBIE);
                        }
                        break lb;
                    }
                }
            }
        }

        return listNPC;
    }
}