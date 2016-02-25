package com.noname.server.json;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by lacau on 25/02/16.
 */
public class SkillIn implements Serializable {

    private static final long serialVersionUID = -5347479098906991418L;

    @NotBlank
    private String name;

    @NotBlank
    private Integer order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}