DROP TABLE IF EXISTS cache;

CREATE TABLE cache
(
    id_cache  VARCHAR(36) PRIMARY KEY,
    lieu      VARCHAR(256) NOT NULL,
    latitude  FLOAT NULL,
    longitude FLOAT NULL,
    id_user   VARCHAR(256),
    type      VARCHAR(32),
    nature    VARCHAR(32),
    etat      VARCHAR(32)
);

DROP TABLE IF EXISTS visite;

CREATE TABLE visite
(
    id_visite   VARCHAR(36) PRIMARY KEY,
    id_cache    VARCHAR(36),
    commentaire VARCHAR(256),
    date        DATETIME,
    photo       VARCHAR(256),
);
