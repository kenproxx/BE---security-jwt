create table role_extend_permissions
(
    role_extend_uid bigint not null,
    permissions_id  bigint not null,
    constraint UK_mvv4df47cj57adi927e60kkbm
        unique (permissions_id)
)
    engine = MyISAM;

create index FKrj281kqv31gtgxxq99gl09d74
    on role_extend_permissions (role_extend_uid);

INSERT INTO tntt.role_extend_permissions (role_extend_uid, permissions_id) VALUES (1, 1);
INSERT INTO tntt.role_extend_permissions (role_extend_uid, permissions_id) VALUES (1, 2);
INSERT INTO tntt.role_extend_permissions (role_extend_uid, permissions_id) VALUES (1, 3);
INSERT INTO tntt.role_extend_permissions (role_extend_uid, permissions_id) VALUES (1, 4);
INSERT INTO tntt.role_extend_permissions (role_extend_uid, permissions_id) VALUES (1, 5);
INSERT INTO tntt.role_extend_permissions (role_extend_uid, permissions_id) VALUES (1, 6);
INSERT INTO tntt.role_extend_permissions (role_extend_uid, permissions_id) VALUES (1, 7);
INSERT INTO tntt.role_extend_permissions (role_extend_uid, permissions_id) VALUES (1, 8);
INSERT INTO tntt.role_extend_permissions (role_extend_uid, permissions_id) VALUES (1, 9);
INSERT INTO tntt.role_extend_permissions (role_extend_uid, permissions_id) VALUES (1, 10);
INSERT INTO tntt.role_extend_permissions (role_extend_uid, permissions_id) VALUES (1, 11);
INSERT INTO tntt.role_extend_permissions (role_extend_uid, permissions_id) VALUES (1, 12);
