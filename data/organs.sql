create table people(
id serial primary key, 
	name varchar(255)
);

create table organs(
id serial primary key, 
	name varchar(255),
	people_id int references people(id) 
);

insert into people(name) values ('Dmitrii');
insert into organs(name, people_id) VALUES ('heart', 1);

select * from people; 
select * from organs where id in (select people_id from organs);
