package com.noname.entity;

import java.io.*;
import javax.persistence.*;

/**
 * Created by lacau on 28/01/16.
 */
//@Entity
public class NPC implements Serializable {

    private static final long serialVersionUID = 6120053498353428193L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cd_id")
    private Long cdId;

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }
}
