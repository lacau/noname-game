CREATE TABLE HERO (
    cd_id serial8 PRIMARY KEY NOT NULL,
    st_name VARCHAR(30) NOT NULL,
    nr_level INTEGER NOT NULL
);

CREATE TABLE SKILL (
    cd_id serial8 PRIMARY KEY NOT NULL,
    st_name VARCHAR(30) NOT NULL,
    st_description VARCHAR(200) NOT NULL,
    nr_power INTEGER NOT NULL
);

CREATE TABLE ITEM (
    cd_id serial8 PRIMARY KEY NOT NULL,
    st_name VARCHAR(30) NOT NULL,
    st_description VARCHAR(200) NOT NULL
);

CREATE TABLE ACHIEVEMENT (
    cd_id serial8 PRIMARY KEY NOT NULL,
    st_name VARCHAR(30) NOT NULL,
    st_description VARCHAR(200) NOT NULL
);

CREATE TABLE ARENA (
    cd_id serial8 PRIMARY KEY NOT NULL,
    st_name VARCHAR(30) NOT NULL
);

CREATE TABLE NPC (
    cd_id serial8 PRIMARY KEY NOT NULL,
    st_name VARCHAR(30) NOT NULL
);