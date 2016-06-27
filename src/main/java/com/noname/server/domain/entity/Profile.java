package com.noname.server.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by lacau on 28/01/16.
 */
@Entity
public class Profile implements Serializable {

    private static final long serialVersionUID = 3033285822549753276L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id")
    private Long cdId;

    @Column(name = "nr_kill")
    private Integer kills;

    @Column(name = "nr_win")
    private Integer wins;

    @Column(name = "nr_loose")
    private Integer looses;

    @Column(name = "nr_die")
    private Integer dies;

    @Column(name = "nr_battle")
    private Integer battles;

    @OneToOne
    @JoinColumn(name = "fk_hero")
    private Hero hero;

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLooses() {
        return looses;
    }

    public void setLooses(Integer looses) {
        this.looses = looses;
    }

    public Integer getDies() {
        return dies;
    }

    public void setDies(Integer dies) {
        this.dies = dies;
    }

    public Integer getBattles() {
        return battles;
    }

    public void setBattles(Integer battles) {
        this.battles = battles;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}