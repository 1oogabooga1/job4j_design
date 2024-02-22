
select i.name, p.name
from item i
join product p
on type_id = i.id
where i.name = 'Сыр';

select * 
from product 
where name like '%мороженое%';

select * 
from product 
where expired_date < '22.02.2024';

select i.name, max(p.price)
from item i
join product p
on type_id = i.id
group by i.name;

select i.name, count(p.name)
from item i
join product p
on type_id=i.id
group by i.name;

select i.name, p.name
from item i
join product p
on type_id = i.id
where i.name in ('Сыр', 'Молоко');

select i.name, count(p.name)
from item i
join product p
on type_id = i.id
group by i.name 
having count(p.name) < 10;

select i.name, p.name 
from item i 
join product p 
on type_id = i.id;


