DROP TABLE IF EXISTS _person_;
DROP TABLE IF EXISTS _item_;

CREATE TABLE _person_(
    person_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    person_name varchar(100)not null,
    person_age int CHECK(person_age>18)
);

CREATE TABLE _item_(
    item_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    item_name varchar(100)not null,
    person_id int REFERENCES _person_(person_id)
);
INSERT INTO _person_(person_name,person_age)VALUES('Tukirkinqmulps',23);
INSERT INTO _item_(item_name,person_id)VALUES('Tomogavk',1);
INSERT INTO _item_(item_name,person_id)VALUES('Tomogavk',1);
INSERT INTO _item_(item_name,person_id)VALUES('Hawk',1);