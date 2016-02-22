package com.noname.server.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.noname.server.enums.SkillType;

/**
 * Created by lacau on 28/01/16.
 */
@Entity
public class Skill implements Serializable {

    private static final long serialVersionUID = -2797937113003680315L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id")
    private Long cdId;

    @Column(name = "st_name")
    private String name;

    @Column(name = "st_description")
    private String description;

    @Column(name = "nr_power")
    private Integer power;

    @Column(name = "st_type")
    private SkillType type;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }
}