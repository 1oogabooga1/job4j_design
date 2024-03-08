create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

insert into products (name, producer, count, price)
VALUES ('product_3', 'producer_3', 8, 115);

insert into products (name, producer, count, price)
VALUES ('product_1', 'producer_1', 3, 50);

create trigger discount_trigger
after insert
on products
for each row
execute procedure discount();

create
or replace function discount()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where count <= 5
        AND id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

insert into products (name, producer, count, price)
VALUES ('product_3', 'producer_3', 8, 115);

create
or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price - price * 0.2
        where id = (select id from inserted)
        and count <= 5;
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert
    on products
    referencing new table as
                    inserted
    for each statement
    execute procedure tax();

create
or replace function taxes()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.05
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger taxes_statement_trigger
after insert
on products
referencing new table as
                    inserted
    for each statement
    execute procedure taxes();

create
or replace function taxes_row()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.05
        where id = new.id;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger taxes_row_trigger
before insert
on products
for each row
execute procedure taxes_row();

create
or replace function price_history()
    returns trigger as
$$
BEGIN
    insert into history_of_price (name, price, date)
    values (NEW.name, NEW.price, CURRENT_TIMESTAMP);
    return NEW;
END;
$$
LANGUAGE 'plpgsql';

create trigger price_history_trigger
after insert
on products
for each row
execute procedure price_history();

insert into products (name, producer, count, price)
VALUES ('product_7', 'producer_7', 9, 100);

select * from history_of_price;

