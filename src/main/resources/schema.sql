-- auto-generated definition
create table "user"
(
    id    serial  not null
        constraint user_pk
            primary key,
    username  varchar not null,
    phone varchar not null
);

alter table "user"
    owner to postgres;

create unique index user_id_uindex
    on "user" (id);

create unique index user_phone_uindex
    on "user" (phone);