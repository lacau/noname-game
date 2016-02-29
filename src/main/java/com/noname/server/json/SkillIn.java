package com.noname.server.json;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

import com.noname.server.enums.SkillType;

/**
 * Created by lacau on 25/02/16.
 */
public class SkillIn implements Serializable {

    private static final long serialVersionUID = -2589973203871288110L;

    @NotNull
    private SkillType type;

    @NotNull
    private Integer order;

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}