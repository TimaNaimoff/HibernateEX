DROP TABLE IF EXISTS actor;

CREATE TABLE actor(
    actor_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	director_id int REFERENCES director(director_id),
	actor_name varchar(30)not null,
	actor_age int CHECK(actor_age>18)
);
INSERT INTO actor(director_id,actor_name,actor_age)VALUES(1,'Macclaren',29);
INSERT INTO actor(director_id,actor_name,actor_age)VALUES(1,'Crowly',33);
INSERT INTO actor(director_id,actor_name,actor_age)VALUES(1,'Iguanosales',544);
INSERT INTO actor(director_id,actor_name,actor_age)VALUES(2,'Pirreydolmeus',46);
INSERT INTO actor(director_id,actor_name,actor_age)VALUES(2,'Semptimy',57);
INSERT INTO actor(director_id,actor_name,actor_age)VALUES(2,'Huanitos',23);
SELECT * FROM actor;