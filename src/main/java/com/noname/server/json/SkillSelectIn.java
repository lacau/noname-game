package com.noname.server.json;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by lacau on 25/02/16.
 */
public class SkillSelectIn implements Serializable {

    private static final long serialVersionUID = -5347479098906991418L;

    @NotBlank
    private Long heroId;

    @NotEmpty
    private List<SkillIn> listSkill;

    public Long getHeroId() {
        return heroId;
    }

    public void setHeroId(Long heroId) {
        this.heroId = heroId;
    }

    public List<SkillIn> getListSkill() {
        return listSkill;
    }

    public void setListSkill(List<SkillIn> listSkill) {
        this.listSkill = listSkill;
    }
}