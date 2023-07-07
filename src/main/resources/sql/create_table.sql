--docker run --name postgres -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres

create table user_table
(
    id   BIGSERIAL primary key,
    name varchar not null,
    likes integer NOT NULL,
    version integer NOT NULL default 0
);

insert into user_table(id, name, likes)
values (1, 'Ann', 0),
       (2, 'Bill', 0),
       (3, 'Cindy', 0),
       (4, 'Diane', 0),
       (5, 'Emma', 0);