insert into categories(name) values ('important');
insert into categories(name) values ('not important');
insert into categories(name) values ('urgent');

insert into users(name, roles_id) values ('Dmitrii', 1);
insert into users(name, roles_id) values ('Igor', 2);
insert into users(name, roles_id) values ('Slava', 3);

insert into items(name, users_id, categories_id, states_id) values ('First item', 1, 1, 1);
insert into items(name, users_id, categories_id, states_id) values ('Second item', 2, 2, 2);
insert into items(name, users_id, categories_id, states_id) values ('Third item', 3, 3, 3);

insert into comments(name, items_id) values ('This item is incorrect', 1);
insert into comments(name, items_id) values ('This item is correct', 2);
insert into comments(name, items_id) values ('This item is fabolous', 1);

insert into attachs(name, items_id) values ('some.png', 1);
insert into attachs(name, items_id) values ('some.txt', 2);
insert into attachs(name, items_id) values ('some.sql', 3);

insert into roles_rules(roles_id, rules_id) values (1, 1);
insert into roles_rules(roles_id, rules_id) values (2, 2);
insert into roles_rules(roles_id, rules_id) values (3, 3);