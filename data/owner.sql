create table property(
id serial primary key, 
	name varchar(255)
);

create table owner(
id serial primary key, 
	name varchar(255),
	property_id int references property(id)
);

insert into property(name) values ('flat');
insert into owner(name, position_id) VALUES ('Dmitrii', 1);

select * from property; 
select * from owner where id in (select property_id from owner);