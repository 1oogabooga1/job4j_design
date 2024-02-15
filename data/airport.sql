create table people(
id serial primary key, 
	name varchar(255)
);

create table airplane(
id serial primary key, 
	ticket varchar(255),
	people_id int references people(id)
);

insert into people(name) values ('Dmitrii');
insert into people(name) values ('Petr'); 
insert into people(name) values ('Sergey');
insert into people(name) values ('Slava');

insert into airplane(ticket, people_id) values ('first seat', 1);
insert into airplane(ticket, people_id) values ('second seat', 2);
insert into airplane(ticket, people_id) values ('third', 3);
insert into airplane(ticket) values ('fourth');

select pp.name Имя, a.ticket Билет from people pp join airplane a on a.people_id = pp.id;  
select pp.name, a.ticket from people pp join airplane a on a.people_id = pp.id;
select pp.name as "Имя Человека", a.ticket as "Билет на самолет" from people pp join airplane a on a.people_id = pp.id;