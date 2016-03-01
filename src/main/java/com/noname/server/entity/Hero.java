package com.noname.server.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 * Created by lacau on 28/01/16.
 */
@Entity
public class Hero implements Serializable {

    private static final long serialVersionUID = -2530786099257695664L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id")
    private Long cdId;

    @Column(name = "st_name")
    private String name;

    @Column(name = "nr_level")
    private Integer level;

    @Column(name = "nr_exp")
    private Long exp;

    @Column(name = "nr_hp")
    private Integer hp;

    @Column(name = "nr_stamina")
    private Integer stamina;

    @Column(name = "nr_str")
    private Integer str;

    @ManyToOne
    @JoinColumn(name = "fk_credential")
    private Credential credential;

    @OneToMany(mappedBy = "hero", cascade = CascadeType.ALL)
    @OrderBy(value = "order")
    private Set<HeroSkill> heroSkills;

    @OneToMany(mappedBy = "hero")
    private Set<HeroItem> heroItems;

    @OneToMany(mappedBy = "hero")
    private Set<HeroAchievement> heroAchievements;

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
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

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public Set<HeroSkill> getHeroSkills() {
        return heroSkills;
    }

    public void setHeroSkills(Set<HeroSkill> heroSkills) {
        this.heroSkills = heroSkills;
    }

    public Set<HeroItem> getHeroItems() {
        return heroItems;
    }

    public void setHeroItems(Set<HeroItem> heroItems) {
        this.heroItems = heroItems;
    }

    public Set<HeroAchievement> getHeroAchievements() {
        return heroAchievements;
    }

    public void setHeroAchievements(Set<HeroAchievement> heroAchievements) {
        this.heroAchievements = heroAchievements;
    }
}