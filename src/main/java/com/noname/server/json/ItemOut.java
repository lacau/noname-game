package com.noname.server.json;

import java.io.Serializable;

/**
 * Created by lacau on 18/02/16.
 */
public class ItemOut implements Serializable {

    private static final long serialVersionUID = 2418710585255302051L;

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