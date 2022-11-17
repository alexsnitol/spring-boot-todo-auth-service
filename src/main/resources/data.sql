CREATE SEQUENCE person_id_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE person
(
    id       BIGINT  NOT NULL DEFAULT NEXTVAL('person_id_sequence'),
    email    VARCHAR(255) UNIQUE,
    name     VARCHAR(255),
    password VARCHAR(255),
    role     VARCHAR(255),
    enabled  BOOLEAN NOT NULL,
    birthday date,
    created  TIMESTAMP,
    modified TIMESTAMP,
    CONSTRAINT pk_person PRIMARY KEY (id)
);

insert into person (name, email, password, role, enabled, birthday, created,modified)
values ('Mark','mark@example.com',
        '{bcrypt}$2a$10$UcwE6kEkbqF91kLuHjSiGeEOZvsdZmA568N6OFG5TJUVz9/7392pe','USER',true,'1960-03-29','2018-08-17 07:42:44.136','2018-08-17 07:42:44.137'),
        ('Matt','matt@example.com',
        '{bcrypt}$2a$10$UcwE6kEkbqF91kLuHjSiGeEOZvsdZmA568N6OFG5TJUVz9/7392pe','USER',true,'1980-07-03','2018-08-17 07:42:44.136','2018-08-17 07:42:44.137'),
        ('Mike','mike@example.com',
        '{bcrypt}$2a$10$EAl0xOPPPPwOsmhW2DekV.8Lpw/gMoKHADnKNSgbqix77.jOsztVC','ADMIN',true,'19820-08-05','2018-08-17 07:42:44.136','2018-08-17 07:42:44.137'),
        ('Dan','dan@example.com',
        '{bcrypt}$2a$10$EAl0xOPPPPwOsmhW2DekV.8Lpw/gMoKHADnKNSgbqix77.jOsztVC','ADMIN',false,'1976-10-11','2018-08-17 07:42:44.136','2018-08-17 07:42:44.137'),
        ('Administrator', 'admin@example.com',
         '{bcrypt}$2a$10$EAl0xOPPPPwOsmhW2DekV.8Lpw/gMoKHADnKNSgbqix77.jOsztVC','ADMIN',true,'1978-12-22','2018-08-17 07:42:44.136','2018-08-17 07:42:44.137')
;