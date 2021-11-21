delete from owner;
insert into owner (first_name, last_name, address, city, telephone) values ( 'Гарри', 'Поттер', 'ул. Тисовая, 4', 'Little Whinging', '0' );
insert into owner (first_name, last_name, address, city, telephone) values ( 'Гермиона', 'Грейнджер', 'Хампстед-Гарден-Саберб', 'Little Whinging', '0' );
insert into owner (first_name, last_name, address, city, telephone) values ( 'Рон', 'Уизли', 'Нора', 'Little Whinging', '0' );
insert into owner (first_name, last_name, address, city, telephone) values ('Невил', 'Долгопупс', 'Хогвардс', 'Шотландия', '0');
insert into owner (first_name, last_name, address, city, telephone) values ('Перси', 'Уизли', 'Нора', 'Little Winging', '0');

insert into owner (first_name, last_name, address, city, telephone) values ('Альбус', 'Дамблдор', 'Хогвардс', 'Шотландия', '0');
insert into owner (first_name, last_name, address, city, telephone) values ('Лорд', 'Волан-де-Морт', 'Особняк Реддлов', 'Литтл-Хэнглтон', '0');
insert into owner (first_name, last_name, address, city, telephone) values ('Сириус', 'Блэк', 'Площадь Гриммо, 12', 'Лондон', '0');

delete from pet_type;
insert into pet_type(name) values ('Кот');       // 1
insert into pet_type(name) values ('Собака');    // 2
insert into pet_type(name) values ('Сова');      // 3
insert into pet_type(name) values ('Крыса');     // 4
insert into pet_type(name) values ('Жаба');      // 5
insert into pet_type(name) values ('Гиппогриф'); // 6
insert into pet_type(name) values ('Феникс');    // 7
insert into pet_type(name) values ('Змея');      // 8

delete from pet;
insert into pet (name, type_id, owner_id, birth_date) values ( 'Букля', 3, 1, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );
insert into pet (name, type_id, owner_id, birth_date) values ( 'Живоглот', 1, 2, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );
insert into pet (name, type_id, owner_id, birth_date) values ( 'Короста', 4, 3, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );
insert into pet (name, type_id, owner_id, birth_date) values ( 'Сычик', 3, 3, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );
insert into pet (name, type_id, owner_id, birth_date) values ( 'Тревор', 5, 4, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );
insert into pet (name, type_id, owner_id, birth_date) values ( 'Стрелка', 3, 5, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );
insert into pet (name, type_id, owner_id, birth_date) values ( 'Фоукс', 7, 6, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );
insert into pet (name, type_id, owner_id, birth_date) values ( 'Ногайна', 8, 7, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );
insert into pet (name, type_id, owner_id, birth_date) values ( 'Клювокрыл', 6, 8, parsedatetime('1989-01-03 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS') );


delete from vet;
insert into vet (first_name, last_name) values ( 'Рубеус', 'Хагрид' );
insert into vet (first_name, last_name) values ( 'Поппи', 'Помфри' );
