package com.noname.server.json;

import java.io.Serializable;

/**
 * Created by lacau on 22/04/16.
 */
public class NPCOut implements Serializable {

    private static final long serialVersionUID = -2006464125583722294L;

    private String name;

    private String type;

    private Integer lvl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLvl() {
        return lvl;
    }

    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }
}