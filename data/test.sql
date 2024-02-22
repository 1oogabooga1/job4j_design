create table roles(
id serial primary key,
	name text
);

create table rules(
id serial primary key,
	name text
);

create table states(
id serial primary key,
	name varchar(255)
);

create table categories(
id serial primary key,
	name varchar(255)
);

create table users(
id serial primary key,
	name text,
	roles_id int references roles(id)
);

create table items(
id serial primary key,
	name text,
	users_id int references users(id),
	categories_id int references categories(id),
	states_id int references states(id)
);

create table comments(
id serial primary key,
	name text,
	items_id int references items(id)
);

create table attachs(
id serial primary key,
	name text,
	items_id int references items(id)
);

create table roles_rules(
id serial primary key, 
	roles_id int references roles(id),
	rules_id int references rules(id)
);

insert into roles(name) values ('Student');
insert into roles(name) values ('Pupil');
insert into roles(name) values ('Worker');

insert into rules(name) values ('Must be at school');
insert into rules(name) values ('Must be at uni');
insert into rules(name) values ('Must be at work');

insert into states(name) values ('In progress');
insert into states(name) values ('Done');
insert into states(name) values ('Does not exist yet');

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