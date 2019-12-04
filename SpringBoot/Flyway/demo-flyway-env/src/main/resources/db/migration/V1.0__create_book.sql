create sequence hibernate_sequence start 1 increment 1;

create table message (
                       id int8 not null,
                       filename varchar(255),
                       tag varchar(255),
                       text varchar(2048) not null,
                       user_id int8,
                       primary key (id)
);