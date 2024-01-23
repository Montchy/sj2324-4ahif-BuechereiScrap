-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

create sequence books_seq start with 1 increment by 50;
create sequence borroweditems_seq start with 1 increment by 50;
create sequence libraries_seq start with 1 increment by 50;
create sequence librarybooks_seq start with 1 increment by 50;
create sequence librarymovies_seq start with 1 increment by 50;
create sequence person_seq start with 1 increment by 50;
create sequence phonenumbers_seq start with 1 increment by 50;
create sequence socialsecuritynumbers_seq start with 1 increment by 50;
create table books (
                       id bigint not null,
                       author varchar(255),
                       blurb varchar(255),
                       genre varchar(255),
                       language varchar(255),
                       main_character varchar(255),
                       publisher varchar(255),
                       title varchar(255),
                       primary key (id)
);

create table borroweditems (
                               borrowed_date date,
                               due_date date,
                               borrowed_book_id bigint,
                               borrowedmovie_id bigint,
                               id bigint not null,
                               library_id bigint,
                               return_policy varchar(255),
                               primary key (id)
);

create table borroweditems_user (
                                    borrowed_item_id bigint not null,
                                    user_id bigint not null,
                                    primary key (borrowed_item_id, user_id)
);

create table employees (
                           age integer not null,
                           is_trainer boolean not null,
                           id bigint not null,
                           manager_id bigint,
                           phone_number_id bigint unique,
                           salary bigint not null,
                           social_security_number_id bigint unique,
                           address varchar(255),
                           job_desc varchar(255),
                           name varchar(255),
                           surname varchar(255),
                           primary key (id)
);

create table employees_employees (
                                     employee_id bigint not null,
                                     employees_id bigint not null unique
);

create table employees_libraries (
                                     employee_id bigint not null,
                                     libraries_id bigint not null unique
);

create table employees_trainings (
                                     trainings_training_start date not null,
                                     employee_id bigint not null,
                                     trainings_trainee_id bigint not null,
                                     primary key (trainings_training_start, employee_id, trainings_trainee_id),
                                     unique (trainings_trainee_id, trainings_training_start)
);

create table libraries (
                           id bigint not null,
                           manager_id bigint,
                           location varchar(255),
                           name varchar(255),
                           primary key (id)
);

create table libraries_borrowed_items (
                                          borrowed_items_id bigint not null unique,
                                          library_id bigint not null,
                                          primary key (borrowed_items_id, library_id)
);

create table librarybooks (
                              is_borrowed boolean not null,
                              book_id bigint,
                              id bigint not null,
                              location varchar(255),
                              primary key (id)
);

create table librarybooks_borrowed_items (
                                             borrowed_items_id bigint not null unique,
                                             library_book_id bigint not null,
                                             primary key (borrowed_items_id, library_book_id)
);

create table librarymovies (
                               age integer not null,
                               release_date date,
                               run_time integer not null,
                               id bigint not null,
                               actors varchar(255),
                               directors varchar(255),
                               genre varchar(255),
                               movie_title varchar(255),
                               plot_summary varchar(255),
                               rating varchar(255),
                               studio varchar(255),
                               primary key (id)
);

create table memberships (
                             general_discount integer not null,
                             member_till date not null,
                             user_id bigint not null,
                             membership_type varchar(255),
                             primary key (member_till, user_id)
);

create table phonenumbers (
                              area_code integer not null,
                              country_code integer not null,
                              serial_num integer not null,
                              id bigint not null,
                              person_id bigint unique,
                              primary key (id)
);

create table socialsecuritynumbers (
                                       birtdate date,
                                       raw_social_number integer not null,
                                       id bigint not null,
                                       person_id bigint unique,
                                       primary key (id)
);

create table training (
                          training_end date,
                          training_start date not null,
                          trainee_id bigint not null,
                          trainer_id bigint,
                          description varchar(255),
                          primary key (training_start, trainee_id)
);

create table users (
                       age integer not null,
                       is_member boolean not null,
                       is_senior boolean not null,
                       is_student boolean not null,
                       id bigint not null,
                       phone_number_id bigint unique,
                       social_security_number_id bigint unique,
                       address varchar(255),
                       name varchar(255),
                       surname varchar(255),
                       primary key (id)
);

create table users_currently_borrowed (
                                          currently_borrowed_id bigint not null,
                                          user_id bigint not null,
                                          primary key (currently_borrowed_id, user_id)
);

create table users_memberships (
                                   memberships_member_till date not null,
                                   memberships_user_id bigint not null,
                                   user_id bigint not null,
                                   primary key (memberships_member_till, memberships_user_id, user_id),
                                   unique (memberships_member_till, memberships_user_id)
);

alter table if exists borroweditems
    add constraint FK218lxrg9wasnhs2tpla3woa90
    foreign key (borrowed_book_id)
    references librarybooks;

alter table if exists borroweditems
    add constraint FKtbgody5myuximkrpwvucghubu
    foreign key (borrowedmovie_id)
    references librarymovies;

alter table if exists borroweditems
    add constraint FKq360pqmprcxgl7syk0t3n4qad
    foreign key (library_id)
    references libraries;

alter table if exists borroweditems_user
    add constraint FKpb0w758qgiciqc5sco5c9nekh
    foreign key (user_id)
    references users;

alter table if exists borroweditems_user
    add constraint FKtohl7cmkt7sjh6qhmyny2bunl
    foreign key (borrowed_item_id)
    references borroweditems;

alter table if exists employees
    add constraint FKi4365uo9af35g7jtbc2rteukt
    foreign key (manager_id)
    references employees;

alter table if exists employees
    add constraint FK_ih0acnxscidm59tu3gj890f1i
    foreign key (phone_number_id)
    references phonenumbers;

alter table if exists employees
    add constraint FK_4nxpcwdkk5ma830k9iuj00d1d
    foreign key (social_security_number_id)
    references socialsecuritynumbers;

alter table if exists employees_employees
    add constraint FK88c9kv0646ssxlq4rhg572cb8
    foreign key (employees_id)
    references employees;

alter table if exists employees_employees
    add constraint FKnxii3jncepuvyigua3gcly312
    foreign key (employee_id)
    references employees;

alter table if exists employees_libraries
    add constraint FKlflsedm1mplu0rhvh124nh9no
    foreign key (libraries_id)
    references libraries;

alter table if exists employees_libraries
    add constraint FKs2qnk74fgcklg8k13y43ab3jj
    foreign key (employee_id)
    references employees;

alter table if exists employees_trainings
    add constraint FK5v9ta2m4uj7k33fp7krspvfm8
    foreign key (trainings_training_start, trainings_trainee_id)
    references training;

alter table if exists employees_trainings
    add constraint FK58a0s5uyk9e1t1h5tjq52ywk6
    foreign key (employee_id)
    references employees;

alter table if exists libraries
    add constraint FKed0lfc2qbbacyjs7uumn1lmyq
    foreign key (manager_id)
    references employees;

alter table if exists libraries_borrowed_items
    add constraint FKq25lt9ly7tylwlryvd316qt44
    foreign key (borrowed_items_id)
    references borroweditems;

alter table if exists libraries_borrowed_items
    add constraint FKaxbka7jb1qjxrdqe2wyosqc2r
    foreign key (library_id)
    references libraries;

alter table if exists librarybooks
    add constraint FKr420aebtqsukkfdhn4hioddm0
    foreign key (book_id)
    references books;

alter table if exists librarybooks_borrowed_items
    add constraint FKc9cqlv69m44ovbpanr4evy7j3
    foreign key (borrowed_items_id)
    references borroweditems;

alter table if exists librarybooks_borrowed_items
    add constraint FKy7xttw6vkbst66irg1aojrem
    foreign key (library_book_id)
    references librarybooks;

alter table if exists memberships
    add constraint FKdjormybfoo7f4i4d4r803qohb
    foreign key (user_id)
    references users;

alter table if exists training
    add constraint FKlnnbak2agm8k9mmq9cm53ampk
    foreign key (trainee_id)
    references employees;

alter table if exists training
    add constraint FK9qygohfqmmq9e2qbqf3rus717
    foreign key (trainer_id)
    references employees;

alter table if exists users
    add constraint FK_91p7em6if9n455tt9dytr2c0a
    foreign key (phone_number_id)
    references phonenumbers;

alter table if exists users
    add constraint FK_690tu6hsuw9g8m4ecw9whyuk6
    foreign key (social_security_number_id)
    references socialsecuritynumbers;

alter table if exists users_currently_borrowed
    add constraint FK4n7piu1uq7tg0k5uha12sc1y3
    foreign key (currently_borrowed_id)
    references borroweditems;

alter table if exists users_currently_borrowed
    add constraint FKsaent055u2gidps4fcfpfcefq
    foreign key (user_id)
    references users;

alter table if exists users_memberships
    add constraint FKi6qrx59sy2gpqwfemkekdy5rk
    foreign key (memberships_member_till, memberships_user_id)
    references memberships;

alter table if exists users_memberships
    add constraint FK49shuqtu4nn5vpkjjd21beeho
    foreign key (user_id)
    references users;

