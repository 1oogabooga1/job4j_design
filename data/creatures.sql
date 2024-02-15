create table fauna(
id serial primary key, 
	name text, 
	avg_age int, 
	discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('dog', 3650, '10.11.1800');
insert into fauna(name, avg_age, discovery_date) values ('cat', 4745, '23.12.250');
insert into fauna(name, avg_age, discovery_date) values ('turtle', 20000, '01.01.50');
insert into fauna(name, avg_age, discovery_date) values ('fly', 20, '12.02.100');
insert into fauna(name, avg_age, discovery_date) values ('bug', 120, null);
 
select * from fauna where name = 'fish';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '02.02.1950';
