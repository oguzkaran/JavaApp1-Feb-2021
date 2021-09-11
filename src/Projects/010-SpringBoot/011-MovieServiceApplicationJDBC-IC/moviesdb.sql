create table movies (
    movie_id bigserial primary key,
    name varchar(256) not null,
    scene_time date not null,
    rating bigint not null default(0),
    cost money not null,
    imdb float4 not null default(0.0)
);


create table students (
    citizen_id char(11) check(length (citizen_id) == 11) unique,
    city varchar(50) not null
);