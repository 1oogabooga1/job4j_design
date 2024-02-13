
insert into items(name) values ('number one');
insert into items(name) values ('number two');

insert into users(name, items_id) values ('Dmitrii', 1);
insert into users(name, items_id) values ('Stas', 2);

insert into roles(name, users_id) values ('Student', 1);
insert into roles(name, users_id) values ('Pupil', 2);

insert into rules(name, roles_id) values ('must be at college', 1);
insert into rules(name, roles_id) values ('must be at school', 2);

insert into comments(name, items_id) values ('Very good item', 1);
insert into comments(name, items_id) values ('Bad item', 2);

insert into attachs(name, items_id) values ('picture.png', 1);
insert into attachs(name, items_id) values ('file.txt', 2);

insert into states(name, items_id) values ('done', 1);
insert into states(name, items_id) values ('in progress', 2);

insert into categories(name, items_id) values ('important', 1);
insert into categories(name, items_id) values ('not important', 2);