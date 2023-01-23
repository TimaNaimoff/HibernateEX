DROP TABLE IF EXISTS person_sec;

CREATE TABLE person_sec(
    person_sec_id integer PRIMARY KEY,
    person_sec_name varchar,
    person_sec_age integer

);
CREATE SEQUENCE person_sec_id_seq;