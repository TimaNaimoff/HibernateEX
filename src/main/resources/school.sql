DROP TABLE IF EXISTS school;

CREATE TABLE school(
   school_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
   _director_id int UNIQUE REFERENCES _director(_director_id)ON DELETE CASCADE,
   school_name varchar(150)not null
);
INSERT INTO school(_director_id,school_name)VALUES(1,'51-IDUM');
INSERT INTO school(_director_id,school_name)VALUES(2,'SAMTUIT');

INSERT INTO school(_director_id,school_name)VALUES(1,'51-IDUM1');
INSERT INTO school(_director_id,school_name)VALUES(2,'SAMTUIT1');


INSERT INTO school(_director_id,school_name)VALUES(1,'51-IDUM2');
INSERT INTO school(_director_id,school_name)VALUES(2,'SAMTUIT2');