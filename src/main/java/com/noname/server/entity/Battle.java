package com.noname.server.entity;

import java.io.*;
import javax.persistence.*;

/**
 * Created by lacau on 28/01/16.
 */
@Entity
public class Battle implements Serializable {

    private static final long serialVersionUID = 4712572552527488499L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_id")
    private Long cdId;

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }
}