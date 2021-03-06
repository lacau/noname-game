package com.noname.server.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Lacau on 04/02/2016.
 */
@Entity
public class ProfileNPC implements Serializable {

    private static final long serialVersionUID = -3701705287548960325L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id")
    private Long cdId;

    @Column(name = "nr_kill")
    private Integer kill;

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }

    public Integer getKill() {
        return kill;
    }

    public void setKill(Integer kill) {
        this.kill = kill;
    }
}
