create table role_extend
(
    uid    bigint auto_increment
        primary key,
    id     varchar(255) not null,
    name   varchar(255) null,
    status varchar(255) null
)
    engine = MyISAM;

INSERT INTO tntt.role_extend (uid, id, name, status) VALUES (1, 'admin', 'admin', '1');
