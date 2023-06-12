DROP SCHEMA IF EXISTS cinema CASCADE;


CREATE SCHEMA IF NOT EXISTS cinema;


CREATE TABLE IF NOT EXISTS cinema.roles (
    id                  SERIAL PRIMARY KEY,
    name                TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS cinema.users (
    id                  SERIAL PRIMARY KEY,
    first_name          TEXT NOT NULL,
    last_name           TEXT NOT NULL,
    username            TEXT,
    phone_number        TEXT NOT NULL,
    email               TEXT NOT NULL,
    password            TEXT,
    verification        TEXT,
    avatar_url          TEXT
);

CREATE TABLE IF NOT EXISTS cinema.user_roles (
    user_id             INTEGER NOT NULL REFERENCES cinema.users(id),
    roles_id            INTEGER NOT NULL REFERENCES cinema.roles(id)
);

CREATE TABLE IF NOT EXISTS cinema.confirmation_tokens (
    id                  SERIAL PRIMARY KEY,
    confirmation_token  TEXT,
    created_date        TIMESTAMP,
    expired_date        TIMESTAMP,
    user_id             INTEGER NOT NULL REFERENCES cinema.users(id)
);

CREATE TABLE IF NOT EXISTS cinema.persistent_logins (
   username             VARCHAR(64) NOT NULL,
   series               VARCHAR(64) NOT NULL,
   token                VARCHAR(64) NOT NULL,
   last_used            TIMESTAMP NOT NULL,
                        PRIMARY KEY (series)
);

CREATE TABLE IF NOT EXISTS cinema.data (
    id                  SERIAL PRIMARY KEY,
    user_id             INTEGER NOT NULL REFERENCES cinema.users(id),
    date                TEXT NOT NULL,
    time                TEXT NOT NULL,
    ip                  TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS cinema.images (
    id                  SERIAL PRIMARY KEY,
    user_id             INTEGER NOT NULL REFERENCES cinema.users(id),
    file_name           TEXT NOT NULL,
    size                TEXT NOT NULL,
    mime                TEXT NOT NULL,
    url                 TEXT
);

CREATE TABLE IF NOT EXISTS cinema.halls (
    id                  SERIAL PRIMARY KEY,
    serial_number       TEXT NOT NULL,
    number_of_seats     TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS cinema.films (
    id                  SERIAL PRIMARY KEY,
    name                TEXT NOT NULL,
    year_of_release     TEXT NOT NULL,
    age_restrictions    TEXT NOT NULL,
    description         TEXT NOT NULL,
    poster_url          TEXT
);

CREATE TABLE IF NOT EXISTS cinema.sessions (
    id                  SERIAL PRIMARY KEY,
    hall_id             INTEGER NOT NULL REFERENCES cinema.halls(id),
    film_id             INTEGER NOT NULL REFERENCES cinema.films(id),
    date_time           TIMESTAMP,
    ticket_cost         TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS cinema.messages (
    id                  SERIAL PRIMARY KEY,
    film_id             INTEGER NOT NULL REFERENCES cinema.films(id),
    author              TEXT NOT NULL,
    content             TEXT NOT NULL
);