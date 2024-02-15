create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   serial primary key,
    name varchar(255)
);

create table devices_people
(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(name, price) values ('Computer', 1000); 
insert into devices(name, price) values ('Laptop', 1500);
insert into devices(name, price) values ('Phone', 500);
insert into devices(name, price) values ('Headphones', 100); 

insert into people(name) values ('Igor');
insert into people(name) values ('Dmitrii');
insert into people(name) values ('Ilya');
insert into people(name) values ('Petr');
insert into people(name) values ('Denis');

insert into devices_people(device_id, people_id) values (1, 1);
insert into devices_people(device_id, people_id) values (2, 3);
insert into devices_people(device_id, people_id) values (3, 4);
insert into devices_people(device_id, people_id) values (4, 5);

select avg(price) from devices;

select p.name, avg(d.price) 
from people p 
join devices_people dp 
on p.id = dp.people_id 
join devices d 
on dp.device_id = d.id 
group by p.name;

select p.name, avg(d.price) 
from people p 
join devices_people dp 
on p.id = dp.people_id 
join devices d 
on dp.device_id = d.id 
group by p.name
having avg(d.price) > 5000;
