-- Tables
create table members (
                         member_id bigserial primary key,
                         username varchar(50) unique not null,
                         password varchar(50) not null,
                         enabled boolean not null
);

create table member_roles (
                              member_role_id bigserial primary key,
                              member_id bigint references members(member_id),
                              role varchar(50) not null
);

-- spring boot check queries
select username, password, enabled from members where username = ?;
select m.username, mr.role as authority from members m inner join member_roles mr on m.member_id = mr.member_id where m.username = ?;

insert into members (username, password, enabled)
values
    ('berkan', '{noop}1234', true),
    ('kaan', '{noop}123', true);


insert into member_roles (member_id, role)
values
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_ADMIN'),
    (2, 'ROLE_USER');

