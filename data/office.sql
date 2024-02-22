create table departments(
id serial primary key, 
	name text
); 

create table employees(
id serial primary key, 
	name text,
	departments_id int references departments(id)
);

create table teens(
id serial primary key, 
	name text, 
	gender text
);

insert into departmens(name) values ('first');
insert into departmens(name) values ('second');
insert into departmens(name) values ('third');
insert into departmens(name) values ('fifth');

insert into employees(name, departments_id) values ('Dmitrii', 1);
insert into employees(name, departments_id) values ('Igor', 2);
insert into employees(name, departments_id) values ('Vasya', 3);

insert into teens(name, gender) values ('Michail', 'Male');
insert into teens(name, gender) values ('Denis', 'Male');
insert into teens(name, gender) values ('Nastya', 'Female');
insert into teens(name, gender) values ('Yulya', 'Female');

select * from employees e
left join departments d 
on e.departments_id = d.id;

select * from employees e
right join departments d 
on e.departments_id = d.id;

select * from employees e
full join departments d 
on e.departments_id = d.id;

select * from employees e
cross join departments d;

select * from departments d
left join employees e 
on e.departments_id = d.id
where e.name is null;

select * from departments d
right join employees e 
on e.departments_id = d.id;

select * from employees e
left join departments d 
on d.id = e.departments_id;

select distinct first.name, second.name 
from teens first 
cross join teens second 
where first.name < second.name 
and first.gender <> second.gender;
