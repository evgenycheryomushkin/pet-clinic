create table pet_type (
    id identity,
    name varchar(255)
);
insert into pet_type(name) values ('CAT');
insert into pet_type(name) values ('DOG');
insert into pet_type(name) values ('OWL');
insert into pet_type(name) values ('RAT');

create table pet (
    id identity,
    name varchar(255),
    type_id long,
    owner_id long,
    birth_date timestamp,
    foreign key (owner_id) references owner(id),
    foreign key (type_id) references pet_type(id)
);
