CREATE TABLE feedback (
    id              UUID            PRIMARY KEY     DEFAULT gen_random_uuid(),
    message         VARCHAR(255)    NOT NULL,
    created_at      TIMESTAMP                       DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP                       DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users (
    id              UUID            PRIMARY KEY     DEFAULT gen_random_uuid(),
    username        VARCHAR(255)    NOT NULL,
    password        varchar(255)    NOT NULL,
    enabled         BOOLEAN,
    created_at      TIMESTAMP                       DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP                       DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE persistent_logins (
    id              UUID            PRIMARY KEY     DEFAULT gen_random_uuid(),
    username        VARCHAR(64)     NOT NULL,
    token           VARCHAR(64)     NOT NULL,
    last_used       TIMESTAMP       NOT NULL
);