package com.noname.server.json;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by lacau on 18/02/16.
 */
public class HeroIn implements Serializable {

    private static final long serialVersionUID = -9205319021065400691L;

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}