package com.noname.server.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Lacau on 04/02/2016.
 */
@Entity
public class HeroSkill implements Serializable {

    private static final long serialVersionUID = -4794110571536784877L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id")
    private Long cdId;

    @Column(name = "nr_level")
    private Integer level;

    @Column(name = "nr_selected")
    private Boolean selected;

    @ManyToOne
    @JoinColumn(name = "fk_hero")
    private Hero hero;

    @ManyToOne
    @JoinColumn(name = "fk_skill")
    private Skill skill;

    public HeroSkill() {
    }

    public HeroSkill(Hero hero, Skill skill, Integer level) {
        this.hero = hero;
        this.skill = skill;
        this.level = level;
    }

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}