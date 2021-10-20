create table pet (
    id identity,
    name varchar(255),
    pet_type int,
    owner_id long,
    birthday timestamp,
    foreign key (owner_id) references owner(id)
)