create table action_entity_set
(
    id            bigint auto_increment
        primary key,
    action        varchar(255) not null,
    default_check bit          null
)
    engine = MyISAM;

INSERT INTO tntt.action_entity_set (id, action, default_check) VALUES (1, 'add', false);
INSERT INTO tntt.action_entity_set (id, action, default_check) VALUES (2, 'query', false);
INSERT INTO tntt.action_entity_set (id, action, default_check) VALUES (3, 'get', false);
INSERT INTO tntt.action_entity_set (id, action, default_check) VALUES (4, 'update', false);
INSERT INTO tntt.action_entity_set (id, action, default_check) VALUES (5, 'delete', false);
INSERT INTO tntt.action_entity_set (id, action, default_check) VALUES (6, 'import', false);
INSERT INTO tntt.action_entity_set (id, action, default_check) VALUES (7, 'export', false);
