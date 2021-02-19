create user isaka identified by shoji account unlock;
grant
    create session,create table,create view,
    create sequence,create synonym,create public synonym to isaka;

    grant select, insert, update, delete, alter on thread to isaka;
    grant select, insert, update, delete, alter on account to isaka;
    grant select, insert, update, delete, alter on res to isaka;

connect isaka/shoji

CREATE TABLE thread(
th_id number(36) constraint pk_th_id primary key,
th_title varchar2(100) not null,
th_date date default sysdate,
th_description varchar2(200),
genre_id number(4),
user_id number(20),
constraint fk_ge_id foreign key(genre_id) REFERENCES genre(genre_id),
constraint fk_us_id foreign key(user_id) REFERENCES account(user_id)
);


CREATE TABLE genre(
    genre_id number(4) constraint pk_ge_id primary key,
    genre_name varchar2(16) not null
);

create table account(
    user_id number(20) constraint pk_us_id primary key,
    user_name varchar2(28) not null,
    user_pass varchar2(16) not null constraint ck_us_ps check(user_pass >= 8)
);

create table res(
    res_id number(10) constraint pk_rs_id primary key,
    res_date date,
    res_text varchar2(500) not null,
    res_count number(10) not null,
    th_id number(36),
    user_id number(20),
    constraint fk_th_id foreign key(th_id) REFERENCES thread(th_id),
    constraint fk_us1_id foreign key(user_id) REFERENCES account(user_id)
);



CREATE SEQUENCE res_id
INCREMENT BY 1
MAXVALUE 1000
START WITH 1;
create sequence user_id
INCREMENT by 1
MAXVALUE 9999
start with 1;
create sequence th_id
INCREMENT by 1
MAXVALUE 9999
start with 1;
create sequence res_count
INCREMENT by 1
MAXVALUE 1000
start with 1;


exit