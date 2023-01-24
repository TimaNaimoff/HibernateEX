DROP TABLE IF EXISTS item;

 CREATE TABLE item(
     item_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
 	person_id int REFERENCES person(person_id)ON DELETE SET NULL,
 	item_name varchar(100)not null
 );
 INSERT INTO item(person_id,item_name) VALUES(1,'Heroes Might and Magic III');
 INSERT INTO item(person_id,item_name) VALUES(2,'Heroes Might and Magic IV');
 INSERT INTO item(person_id,item_name) VALUES(3,'Heroes Might and Magic II');
 INSERT INTO item(person_id,item_name) VALUES(1,'Heroes Might and Magic I');
 INSERT INTO item(person_id,item_name) VALUES(2,'Heroes Might and Magic V');
 INSERT INTO item(person_id,item_name) VALUES(2,'Might and Magic VI');