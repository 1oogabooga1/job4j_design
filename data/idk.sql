create table concert(
id serial primary key, 
	name text
);

create table ticket(
id serial primary key,
	concert_id int references concert(id),
	name text
);

create table people(
id serial primary key, 
	name text 
);

create table orders(
id serial primary key, 
	people_id int references people(id),
	ticket_id int references ticket(id)
);

insert into concert(name) values ('first');
insert into concert(name) values ('second');
insert into concert(name) values ('third');

insert into ticket(name, concert_id) values ('VIP', 1);
insert into ticket(name, concert_id) values ('DanceFloor', 2);
insert into ticket(name, concert_id) values ('Stage', 3);
insert into ticket(name, concert_id) values ('VIP', 1);
insert into ticket(name, concert_id) values ('DanceFloor', 2);
insert into ticket(name, concert_id) values ('Stage', 3);
insert into ticket(name, concert_id) values ('VIP', 1);
insert into ticket(name, concert_id) values ('DanceFloor', 2);
insert into ticket(name, concert_id) values ('Stage', 3);

insert into people(name) values('Dmitrii');
insert into people(name) values('Slava');
insert into people(name) values('Denis');
								
insert into orders(people_id, ticket_id) values (1, 1);
insert into orders(people_id, ticket_id) values (1, 2);
insert into orders(people_id, ticket_id) values (1, 3);
insert into orders(people_id, ticket_id) values (2, 1);
insert into orders(people_id, ticket_id) values (2, 2);
insert into orders(people_id, ticket_id) values (2, 3);
insert into orders(people_id, ticket_id) values (3, 1);
insert into orders(people_id, ticket_id) values (3, 2);
insert into orders(people_id, ticket_id) values (3, 3);
								
create view people_who_has_3_tickets
as
select p.name as people, count(t.name), t.name as ticket
from people as p
			join orders o on p.id = o.people_id
			join ticket t on o.ticket_id = t.id
			join concert c on t.concert_id = c.id
group by (p.name, t.name)
having count(t.name) >= 3;

select * from people_who_has_3_tickets;