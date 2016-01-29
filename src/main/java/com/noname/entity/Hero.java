package com.noname.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by lacau on 28/01/16.
 */
//@Entity
public class Hero implements Serializable {

    private static final long serialVersionUID = -2530786099257695664L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cd_id")
    private Long cdId;
}
