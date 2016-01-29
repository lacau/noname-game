package com.noname.entity;

import java.io.*;
import javax.persistence.*;

/**
 * Created by lacau on 28/01/16.
 */
@Entity
public class Hero implements Serializable {

    private static final long serialVersionUID = -2530786099257695664L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cd_id")
    private Long cdId;

    @Column(name = "name")
    private String name;

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }

    public String getName() {
        return name;
    }

    public Hero setName(String name) {
        this.name = name;
        return this;
    }
}
