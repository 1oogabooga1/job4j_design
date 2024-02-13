create table users(
id serial primary key,
	name text,
	items_id int references items(id)
);

create table roles(
id serial primary key,
	name text,
	users_id int references users(id)
);

create table rules(
id serial primary key,
	name text,
	roles_id int references roles(id)
);

create table items(
id serial primary key,
	name text
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

create table states(
id serial primary key,
	name varchar(255),
	items_id int references items(id)
);

create table categories(
id serial primary key,
	name varchar(255),
	items_id int references items(id)
);