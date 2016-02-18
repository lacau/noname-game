package com.noname.server.json;

import java.io.Serializable;

/**
 * Created by lacau on 18/02/16.
 */
public class SkillOut implements Serializable {

    private static final long serialVersionUID = 4297071199682679053L;

    private String name;

    private Integer level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}