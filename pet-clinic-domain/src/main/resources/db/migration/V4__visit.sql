create table visit (
    id identity,
    date date,
    description clob,
    pet_id long,
    foreign key (pet_id) references pet
);

