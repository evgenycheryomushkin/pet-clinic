delete from owner;
insert into owner (first_name, last_name, address, city, telephone) values ( 'Гарри', 'Поттер', 'ул. Тисовая, 4', 'Little Whinging', '0' );
insert into owner (first_name, last_name, address, city, telephone) values ( 'Гермиона', 'Грейнджер', 'Хампстед-Гарден-Саберб', 'Little Whinging', '0' );
insert into owner (first_name, last_name, address, city, telephone) values ( 'Рон', 'Уизли', 'Нора', 'Little Whinging', '0' );

delete from pet;
insert into pet (name, type_id, owner_id, birth_date) values ( 'Букля', 3, 1, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );
insert into pet (name, type_id, owner_id, birth_date) values ( 'Живоглот', 1, 2, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );
insert into pet (name, type_id, owner_id, birth_date) values ( 'Короста', 4, 3, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );

delete from vet;
insert into vet (first_name, last_name) values ( 'Северус', 'Снегг' )
