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
    created_at      TIMESTAMP                       DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP                       DEFAULT CURRENT_TIMESTAMP
);

--username: user
--password: password
insert into users (username, password, enabled) values ('user', '$2a$12$KmCZtcpZhNsSoq/Gv/KaBuP3IxyT9ifCSWD.kd3qOoDAyHLsypLEK', true);

--username: the_random_guy
--password: hello123
insert into users (username, password, enabled) values ('the_random_guy', '$2a$12$do0WovKXIOOFlina3uOl9uYGyk4LLU7AZcQOwmmMpb3i1HVXnsHre', true);
