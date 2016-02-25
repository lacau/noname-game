package com.noname.server.enums;

/**
 * Created by lacau on 24/02/16.
 */
public enum NPCType {

    DRAGON(1),
    GOLEM(8),
    BEAR(20),
    SPIDER(45),
    ZOMBIE(95);

    private int percent;

    NPCType(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }
}