package com.noname.entity;

import java.io.*;
import javax.persistence.*;

/**
 * Created by lacau on 28/01/16.
 */
//@Entity
public class Achievement implements Serializable {

    private static final long serialVersionUID = 7574799314038248717L;

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
