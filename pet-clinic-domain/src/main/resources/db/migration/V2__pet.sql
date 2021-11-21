create table pet_type (
    id identity,
    name varchar(255)
);

create table pet (
    id identity,
    name varchar(255),
    type_id long,
    owner_id long,
    birth_date date,
    foreign key (owner_id) references owner(id),
    foreign key (type_id) references pet_type(id)
);
