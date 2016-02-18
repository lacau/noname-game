package com.noname.server.json;

import java.io.Serializable;

/**
 * Created by lacau on 18/02/16.
 */
public class SkillOut implements Serializable {

    private static final long serialVersionUID = 4297071199682679053L;

    private String name;

    private String description;

    private Integer power;

    private Integer level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}