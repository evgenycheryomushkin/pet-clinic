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
insert into pet_type(name)
values ('Кот'),       // 1
       ('Собака'),    // 2
       ('Сова'),      // 3
       ('Крыса'),     // 4
       ('Жаба'),      // 5
       ('Гиппогриф'), // 6
       ('Феникс'),    // 7
       ('Змея');      // 8

delete from pet;
insert into pet (name, type_id, owner_id, birth_date)
values ('Букля', 3, 1, date '1989-01-01'),
       ('Живоглот', 1, 2, date '1989-01-01'),
       ('Короста', 4, 3, date '1989-01-01'),
       ('Сычик', 3, 3, date '1989-01-01'),
       ('Тревор', 5, 4, date '1989-01-01'),
       ('Стрелка', 3, 5, date '1989-01-01'),
       ('Фоукс', 7, 6, date '1989-01-01'),
       ('Ногайна', 8, 7, date '1989-01-01'),
       ('Клювокрыл', 6, 8, date '1989-01-01');


delete from vet;
insert into vet (first_name, last_name) values ( 'Рубеус', 'Хагрид' );
insert into vet (first_name, last_name) values ( 'Поппи', 'Помфри' );
