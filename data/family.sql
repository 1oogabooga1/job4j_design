create table family(
id serial primary key,
	siblings integer,
	city varchar(255),
	members text
);
insert into family(siblings, city, members) values(2, 'Moscow', 'Anastasia, Dmitrii, Artem, Vasya');
update family set siblings = 4;
delete from family;
select * from family; 