package com.noname.server.json;

import java.io.Serializable;

/**
 * Created by lacau on 22/02/16.
 */
public class AchievementOut implements Serializable {

    private static final long serialVersionUID = 9200242115813083363L;

    private String name;

    private String description;

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
}