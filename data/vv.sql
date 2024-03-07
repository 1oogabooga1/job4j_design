create table human(
id serial primary key,
	name text,
	address text
);
create table product(
id serial primary key,
	name text
);

create table delivery(
id serial primary key,
	time text
);
create table orders(
id serial primary key,
	human_id int references human(id),
	product_id int references product(id),
	delivery_id int references delivery(id)
);

insert into human(name, address) values ('Dmitrii', 'Podushkino 25');
insert into human(name, address) values ('Ivan', 'Micheenko 40');
insert into human(name, address) values ('Sergei', 'Arbat 24');
insert into human(name, address) values ('Daniil', 'Tversakaya 10');

insert into product(name) values ('Cheese');
insert into product(name) values ('Milk');
insert into product(name) values ('Eggs');
insert into product(name) values ('Bread');
insert into product(name) values ('Sausage');
insert into product(name) values ('Ketchup');
insert into product(name) values ('Coke');
insert into product(name) values ('Butter');

insert into delivery(time) values ('1 hour');
insert into delivery(time) values ('2 houres');
insert into delivery(time) values ('3 houres');
insert into delivery(time) values ('30 mins');
insert into delivery(time) values ('20 mins');
insert into delivery(time) values ('1.5 hour');

insert into orders(human_id, product_id, delivery_id) values (1, 1, 1);
insert into orders(human_id, product_id, delivery_id) values (1, 2, 1);
insert into orders(human_id, product_id, delivery_id) values (1, 3, 1);
insert into orders(human_id, product_id, delivery_id) values (1, 3, 1);
insert into orders(human_id, product_id, delivery_id) values (1, 3, 1);
insert into orders(human_id, product_id, delivery_id) values (1, 4, 1);
insert into orders(human_id, product_id, delivery_id) values (1, 4, 1);
insert into orders(human_id, product_id, delivery_id) values (2, 1, 2);
insert into orders(human_id, product_id, delivery_id) values (2, 2, 2);
insert into orders(human_id, product_id, delivery_id) values (2, 2, 2);
insert into orders(human_id, product_id, delivery_id) values (2, 3, 2);
insert into orders(human_id, product_id, delivery_id) values (2, 5, 2);
insert into orders(human_id, product_id, delivery_id) values (2, 5, 2);
insert into orders(human_id, product_id, delivery_id) values (2, 5, 2);
insert into orders(human_id, product_id, delivery_id) values (2, 8, 2);
insert into orders(human_id, product_id, delivery_id) values (2, 8, 2);
insert into orders(human_id, product_id, delivery_id) values (3, 1, 5);
insert into orders(human_id, product_id, delivery_id) values (3, 7, 5);
insert into orders(human_id, product_id, delivery_id) values (3, 7, 5);
insert into orders(human_id, product_id, delivery_id) values (4, 6, 6);

create view people_with_2_or_more_product
as
select h.name as human, count(p.name), p.name as product, d.time as delivery
from human as h 
join orders o on h.id = o.human_id
join delivery d on o.delivery_id = d.id
join product p on o.product_id = p.id
group by (h.name, p.name, d.time)
having count(p.name) >= 2;

select * from people_with_2_or_more_product;