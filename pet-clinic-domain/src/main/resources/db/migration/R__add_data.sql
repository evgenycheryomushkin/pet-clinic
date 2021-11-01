delete from owner;
insert into owner (first_name, last_name) values ( 'Гарри', 'Поттер' );
insert into owner (first_name, last_name) values ( 'Гермиона', 'Грейнджер' );
insert into owner (first_name, last_name) values ( 'Рон', 'Уизли' );

delete from pet;
insert into pet (name, pet_type_id, owner_id, birthday) values ( 'Букля', 3, 1, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );
insert into pet (name, pet_type_id, owner_id, birthday) values ( 'Живоглот', 1, 1, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );
insert into pet (name, pet_type_id, owner_id, birthday) values ( 'Короста', 4, 1, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );

delete from vet;
insert into vet (first_name, last_name) values ( 'Северус', 'Снегг' )