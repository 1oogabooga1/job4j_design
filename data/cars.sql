create table car_bodies(
id serial primary key, 
	name text
);

create table car_engines(
id serial primary key,
	name text
);

create table car_transmissions(
id serial primary key,
	name text
);

create table cars(
id serial primary key,
	name text,
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmissions_id int references car_transmissions(id)
);

insert into car_bodies(name) values ('седан');
insert into car_bodies(name) values ('хэтчбек');
insert into car_bodies(name) values ('пикап');

insert into car_engines(name) values ('Дизельный');
insert into car_engines(name) values ('Бензиновый');
insert into car_engines(name) values ('Электрический');
insert into car_engines(name) values ('Внутреннего сгорания');

insert into car_transmissions(name) values ('Механическая');
insert into car_transmissions(name) values ('Гидравлическая');
insert into car_transmissions(name) values ('Автоматическая');
insert into car_transmissions(name) values ('Гидростатическая');

insert into cars(name, body_id, engine_id, transmissions_id) values ('Volkswagen', 1, 1, 1);
insert into cars(name, body_id, engine_id, transmissions_id) values ('Mercedes', 2, 2, 2);
insert into cars(name, body_id, engine_id, transmissions_id) values ('Toyota', 3, 3, 3);

select c.name, b.name, e.name, t.name 
from cars c
left join car_bodies b on c.body_id = b.id
left join car_engines e on c.engine_id = e.id
left join car_transmissions t on c.transmissions_id = t.id;

select b.name 
from car_bodies b 
left join cars c 
on b.id = c.body_id
where c.body_id is null;

select e.name 
from car_engines e 
left join cars c 
on e.id = c.engine_id
where c.engine_id is null;

select t.name 
from car_transmissions t 
left join cars c 
on t.id = c.transmissions_id
where c.transmissions_id is null;
