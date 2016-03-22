package com.noname.server.json;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lacau on 18/02/16.
 */
public class HeroOut implements Serializable {

    private static final long serialVersionUID = -5763726954213595900L;

    private Long id;

    private String name;

    private Integer level;

    private Long exp;

    private Integer hp;

    private Integer stamina;

    private Integer str;

    private List<SkillOut> skills;

    private List<ItemOut> items;

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

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getStamina() {
        return stamina;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public Integer getStr() {
        return str;
    }

    public void setStr(Integer str) {
        this.str = str;
    }

    public List<SkillOut> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillOut> skills) {
        this.skills = skills;
    }

    public List<ItemOut> getItems() {
        return items;
    }

    public void setItems(List<ItemOut> items) {
        this.items = items;
    }
}