create
or replace function delete_data(u_count integer, tax float, u_id integer)
returns integer
language 'plpgsql'
as
$$
    declare
        result integer;
    begin
        if u_count = 0 THEN
            delete from products;
        end if;
       
        return result;
    end;
$$;
select delete_data(0, 0, 0);
create
or replace procedure delete_data_procedure(u_count integer, tax float, u_id integer)
language 'plpgsql'
as $$
    BEGIN
        if u_count = 0 THEN
		delete from products;
        end if;
    END;
$$;

call delete_data_procedure(0, 0, 0);