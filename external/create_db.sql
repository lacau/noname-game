CREATE TABLE HERO (
    cd_id serial PRIMARY KEY NOT NULL,
    st_name VARCHAR(30) NOT NULL,
    nr_level INTEGER NOT NULL
);

CREATE TABLE SKILL (
    cd_id serial PRIMARY KEY NOT NULL,
    st_name VARCHAR(30) NOT NULL,
    st_description VARCHAR(200) NOT NULL,
    nr_power INTEGER NOT NULL
);

CREATE TABLE HERO_SKILL (
    cd_id serial PRIMARY KEY NOT NULL,
    fk_hero INTEGER NOT NULL,
    fk_skill INTEGER NOT NULL,
    nr_level INTEGER NOT NULL,
    fl_selected BOOL NOT NULL
)

CREATE TABLE ITEM (
    cd_id serial PRIMARY KEY NOT NULL,
    st_name VARCHAR(30) NOT NULL,
    st_description VARCHAR(200) NOT NULL
);

CREATE TABLE HERO_ITEM (
    cd_id serial PRIMARY KEY NOT NULL,
    fk_hero INTEGER NOT NULL,
    fk_item INTEGER NOT NULL
)

CREATE TABLE ACHIEVEMENT (
    cd_id serial PRIMARY KEY NOT NULL,
    st_name VARCHAR(30) NOT NULL,
    st_description VARCHAR(200) NOT NULL
);

CREATE TABLE HERO_ACHIEVEMENT (
    cd_id serial PRIMARY KEY NOT NULL,
    fk_hero INTEGER NOT NULL,
    fk_achievement INTEGER NOT NULL
)

CREATE TABLE ARENA (
    cd_id serial PRIMARY KEY NOT NULL,
    st_name VARCHAR(30) NOT NULL
);

CREATE TABLE HERO_ARENA (
    cd_id serial PRIMARY KEY NOT NULL,
    fk_hero INTEGER NOT NULL,
    fk_arena INTEGER NOT NULL
)

CREATE TABLE NPC (
    cd_id serial PRIMARY KEY NOT NULL,
    st_name VARCHAR(30) NOT NULL
);