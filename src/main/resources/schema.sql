create table hibernate_schema.persons
(
    name           varchar(30) not null,
    surname        varchar(50) not null,
    age            smallint    not null check ( age > 0 and age < 130 ),
    phone_number   varchar(11),
    city_of_living varchar(30),

    primary key (name, surname, age)
);


insert into hibernate_schema.persons (name, surname, age, phone_number, city_of_living)
values ('Vasya', 'Petrov', 26, 89031111111, 'Moscow');

insert into hibernate_schema.persons (name, surname, age, phone_number, city_of_living)
values ('Petya', 'Vasin', 27, 89032222222, 'Piter');

insert into hibernate_schema.persons (name, surname, age, phone_number, city_of_living)
values ('Kolya', 'Ivanov', 28, 89033333333, 'Kostroma');

insert into hibernate_schema.persons (name, surname, age, phone_number, city_of_living)
values ('Ivan', 'Kolin', 29, 89034444444, 'Moscow');