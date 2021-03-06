CREATE TABLE HERO (
    cd_id serial PRIMARY KEY NOT NULL,
    st_name VARCHAR(30) NOT NULL,
    nr_level INTEGER NOT NULL
);

CREATE TABLE PROFILE (
    cd_id serial PRIMARY KEY NOT NULL,
    fk_hero INTEGER NOT NULL,
    nr_kill INTEGER NOT NULL,
    nr_win INTEGER NOT NULL,
    nr_loose INTEGER NOT NULL,
    nr_die INTEGER NOT NULL,
    nr_battle INTEGER NOT NULL
)

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

CREATE TABLE PROFILE_NPC (
    cd_id serial PRIMARY KEY NOT NULL,
    fk_profile INTEGER NOT NULL,
    fk_npc INTEGER NOT NULL,
    nr_kill INTEGER NOT NULL
);

CREATE TABLE BATTLE (
    cd_id serial PRIMARY KEY NOT NULL,
    fk_hero INTEGER NOT NULL,
    fk_enemy INTEGER NOT NULL
)

CREATE TABLE BATTLE_LOG (
    cd_id serial PRIMARY KEY NOT NULL,
    fk_battle INTEGER NOT NULL
)

CREATE TABLE STORE (
    cd_id serial PRIMARY KEY NOT NULL
)

CREATE TABLE STORE_ITEM (
    cd_id serial PRIMARY KEY NOT NULL,
    fk_store INTEGER NOT NULL,
    fk_item INTEGER NOT NULL
)

CREATE TABLE CREDENTIAL (
    cd_id serial PRIMARY KEY NOT NULL,
    st_login VARCHAR(30) NOT NULL,
    st_password VARCHAR(200) NOT NULL,
    st_token VARCHAR(200) NOT NULL,
    dt_token TIMESTAMP NOT NULL
)

CREATE TABLE CREDENTIAL_HERO (
    cd_id serial PRIMARY KEY NOT NULL,
    fk_credential INTEGER NOT NULL,
    fk_hero INTEGER NOT NULL
)