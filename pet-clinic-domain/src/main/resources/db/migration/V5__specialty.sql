create table specialty (
    id identity,
    name varchar(255)
);

create table vet_specialties (
    vet_id long,
    specialties_id long,
    foreign key (vet_id) references vet(id),
    foreign key (specialties_id) references specialty(id)
);