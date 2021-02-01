DROP TABLE IF EXISTS visite;

DROP TABLE IF EXISTS cache;

DROP TABLE IF EXISTS utilisateur;

CREATE TABLE utilisateur
(
    id_utilisateur VARCHAR(36) PRIMARY KEY,
    description    VARCHAR(256),
    photo          VARCHAR(256)
);

CREATE TABLE cache
(
    id_cache       VARCHAR(36) PRIMARY KEY,
    id_utilisateur VARCHAR(36),
    lieu           VARCHAR(256) NOT NULL,
    latitude       FLOAT NULL,
    longitude      FLOAT NULL,
    type           VARCHAR(32),
    nature         VARCHAR(32),
    etat           VARCHAR(32),
    CONSTRAINT cache_utilisateur_fk
        FOREIGN KEY (id_utilisateur) REFERENCES utilisateur (id_utilisateur)
            ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE visite
(
    id_visite      VARCHAR(36) PRIMARY KEY,
    id_cache       VARCHAR(36),
    id_utilisateur VARCHAR(36),
    commentaire    VARCHAR(256),
    date           DATETIME,
    photo          VARCHAR(256),
    CONSTRAINT visite_cache_fk
        FOREIGN KEY (id_cache) REFERENCES cache (id_cache)
            ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT visite_utilisateur_fk
        FOREIGN KEY (id_utilisateur) REFERENCES utilisateur (id_utilisateur)
            ON UPDATE CASCADE ON DELETE CASCADE
);
