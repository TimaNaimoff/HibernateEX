DROP TABLE IF EXISTS person;

CREATE TABLE person(
    person_id int PRIMARY KEY,
    person_name varchar,
    person_age int
);
INSERT INTO person(person_id,person_name,person_age)VALUES(1,'Tiraksor',29);

SELECT * FROM person;