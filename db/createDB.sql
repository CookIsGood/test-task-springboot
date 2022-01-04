-- auto-generated definition

drop table if exists "user" cascade;


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

INSERT INTO "user" (username, phone) VALUES ('Вася', '+79632223223');
INSERT INTO "user" (username, phone) VALUES ('Петя', '+7963224343');
INSERT INTO "user" (username, phone) VALUES ('Миша', '+796893223223');
INSERT INTO "user" (username, phone) VALUES ('Алексей', '+7963229993223');
INSERT INTO "user" (username, phone) VALUES ('Маша', '+79632323223');