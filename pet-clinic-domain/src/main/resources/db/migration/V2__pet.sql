create table pet_type (
    id identity,
    name varchar(255)
);
insert into pet_type(name) values ('CAT');
insert into pet_type(name) values ('DOG');
insert into pet_type(name) values ('OWL');

create table pet (
    id identity,
    name varchar(255),
    pet_type_id long,
    owner_id long,
    birthday timestamp,
    foreign key (owner_id) references owner(id),
    foreign key (pet_type_id) references pet_type(id)
);