package com.noname.server.json;

import java.io.Serializable;

import com.noname.server.enums.SkillType;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by lacau on 25/02/16.
 */
public class SkillIn implements Serializable {

    private static final long serialVersionUID = -2589973203871288110L;

    @NotBlank
    private SkillType type;

    @NotBlank
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