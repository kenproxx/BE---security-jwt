create table role
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
)
    engine = MyISAM;

INSERT INTO tntt.role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO tntt.role (id, name) VALUES (2, 'ROLE_USER');
