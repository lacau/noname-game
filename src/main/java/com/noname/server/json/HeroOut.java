package com.noname.server.json;

import java.io.Serializable;

/**
 * Created by lacau on 18/02/16.
 */
public class HeroOut implements Serializable {

    private static final long serialVersionUID = -5763726954213595900L;

    private Long id;

    private String name;

    private Integer level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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