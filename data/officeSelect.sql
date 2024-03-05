select * from employees e
left join departments d on e.departments_id = d.id;

select * from employees e
right join departments d on e.departments_id = d.id;

select * from employees e
full join departments d on e.departments_id = d.id;

select * from employees e
cross join departments d;

select * from departments d
left join employees e on e.departments_id = d.id
where e.name is null;

select * from departments d
right join employees e on e.departments_id = d.id;

select * from employees e
left join departments d on d.id = e.departments_id;

select distinct first.name, second.name 
from teens AS first 
cross join teens AS second 
where first.gender < second.gender;