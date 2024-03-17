CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);
insert into customers(first_name, last_name, age, country) values ('Dmitrii', 'Dobrydin', 18, 'Russia');
insert into customers(first_name, last_name, age, country) values ('Denis', 'Kornilov', 19, 'Russia');
insert into customers(first_name, last_name, age, country) values ('Ivan', 'Zaprudnov', 17, 'Russia');
insert into customers(first_name, last_name, age, country) values ('Igor', 'Korolev', 15, 'Russia');
insert into customers(first_name, last_name, age, country) values ('Vasya', 'Vasnetsov', 15, 'Russia');
select * from customers where age = (select min(age) from customers);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);
insert into orders(amount, customer_id) values (5, 1);
insert into orders(amount, customer_id) values (3, 3);
insert into orders(amount, customer_id) values (10, 4);
select * from customers where customers.id not in (select customer_id from orders);