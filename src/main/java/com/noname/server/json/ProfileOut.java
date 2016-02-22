package com.noname.server.json;

import java.io.Serializable;

/**
 * Created by lacau on 22/02/16.
 */
public class ProfileOut implements Serializable {

    private static final long serialVersionUID = 2965735421686412674L;

    private Integer kills;

    private Integer wins;

    private Integer looses;

    private Integer dies;

    private Integer battles;

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
}