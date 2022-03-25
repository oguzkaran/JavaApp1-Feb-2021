-- Default user tables
create table users (
    username varchar(50) primary key not null,
    password varchar(100) not null,
    enabled smallint not null
);

create table authorities (
    authority_id serial primary key,
    username varchar(50) references users(username),
    authority varchar(50) not null
);


create or replace function insert_user(varchar(50), varchar(100), smallint)
returns void
as $$
begin
    insert into users (username, password, enabled) values ($1, $2, $3);
end
$$ language plpgsql;


create or replace procedure sp_insert_authority(varchar(50), varchar(50))
language plpgsql
as $$
begin
    insert into authorities (username, authority) values ($1, $2);
end
$$;



-- ROLE_SYS_ADMIN, ROLE_ADMIN, ROLE_SYSTEM, ROLE_USER, ROLE_VIEWER



