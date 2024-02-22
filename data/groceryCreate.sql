create table item(
id serial primary key,
	name text
);

create table product(
id serial primary key,
	name text,
	type_id references type(id),
	expired_date timestamp,
	price int
);