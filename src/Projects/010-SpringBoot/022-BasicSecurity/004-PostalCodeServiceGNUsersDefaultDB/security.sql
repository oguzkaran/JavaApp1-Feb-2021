-- Default user tables
create table users (
    username varchar(50) primary key not null,
    password varchar(50) not null,
    enabled smallint not null
);

create table authorities (
    authority_id serial primary key,
    username varchar(50) references users(username),
    authority varchar(50) not null
);

-- spring boot default check queries
select username, password, enabled from users
where username = ?;

select username, authority from authorities
where username = ?

-- Sample users

    insert into users (username, password, enabled)
values
    ('bora', '{noop}12345', 1),
    ('coskun', '{noop}1234', 1),
    ('onur', '{noop}123456', 1),
    ('oguz', '{noop}123', 1);

insert into authorities (username, authority)
values
    ('bora', 'ADMIN'),
    ('bora', 'USER'),
    ('coskun', 'USER'),
    ('onur', 'USER'),
    ('oguz', 'USER');