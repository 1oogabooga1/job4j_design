create table people(
id serial primary key, 
	name varchar(255)
);

create table addiction(
id serial primary key, 
	name varchar(255)
);

create table people_addiction(
id serial primary key,
	people_id int references people(id),
	addiction_id int references addiction(id)
);

insert into people(name) values('Dmitrii');
insert into people(name) values ('Denis');
insert into people(name) values ('Ivan');

insert into addiction(name) values ('oxygen');
insert into addiction(name) values ('coffee');
insert into addiction(name) values ('sugar');

insert into people_addiction(people_id, addiction_id) values (1, 3);
insert into people_addiction(people_id, addiction_id) values (1, 2);
insert into people_addiction(people_id, addiction_id) values (2, 3);
insert into people_addiction(people_id, addiction_id) values (3, 3);