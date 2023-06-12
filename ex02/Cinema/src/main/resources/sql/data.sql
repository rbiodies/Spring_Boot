INSERT INTO cinema.roles (name)
VALUES ('ROLE_USER');
INSERT INTO cinema.roles (name)
VALUES ('ROLE_ADMIN');

INSERT INTO cinema.users (first_name, last_name, username, phone_number, email, password, verification, avatar_url)
VALUES ('Alexandr', 'Pushkin', null, '88005353535', 'winter@yandex.ru', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', 'CONFIRMED', null);
INSERT INTO cinema.users (first_name, last_name, username, phone_number, email, password, verification, avatar_url)
VALUES ('Mihail', 'Lermontov', null, '88005353532', 'luna@ya.ru', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', 'CONFIRMED', null);
INSERT INTO cinema.users (first_name, last_name, username, phone_number, email, password, verification, avatar_url)
VALUES ('Fedor', 'Dostoevskiy', null, '88005353536', 'prestuplenie@mail.com', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', 'CONFIRMED', null);
INSERT INTO cinema.users (first_name, last_name, username, phone_number, email, password, verification, avatar_url)
VALUES ('Mihail', 'Bulgakov', null, '88005353636', 'margarita@gmail.com', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', 'CONFIRMED', null);
INSERT INTO cinema.users (first_name, last_name, username, phone_number, email, password, verification, avatar_url)
VALUES ('Sergey', 'Esenin', null, '88005353530', 'senya@yandex.ru', '$2a$10$C8doa07v8LMG5FaEBkmWRekibKatudakwH2wVwgWZkzeVjeE.y536', 'NOT_CONFIRMED', null);

INSERT INTO cinema.user_roles (user_id, roles_id)
VALUES (1, 2);
INSERT INTO cinema.user_roles (user_id, roles_id)
VALUES (2, 1);
INSERT INTO cinema.user_roles (user_id, roles_id)
VALUES (2, 2);
INSERT INTO cinema.user_roles (user_id, roles_id)
VALUES (3, 1);
INSERT INTO cinema.user_roles (user_id, roles_id)
VALUES (4, 1);
INSERT INTO cinema.user_roles (user_id, roles_id)
VALUES (5, 1);

INSERT INTO cinema.confirmation_tokens (confirmation_token, expired_date, user_id)
VALUES (null, null, 1);
INSERT INTO cinema.confirmation_tokens (confirmation_token, expired_date, user_id)
VALUES (null, null, 2);
INSERT INTO cinema.confirmation_tokens (confirmation_token, expired_date, user_id)
VALUES (null, null, 3);
INSERT INTO cinema.confirmation_tokens (confirmation_token, expired_date, user_id)
VALUES (null, null, 4);
INSERT INTO cinema.confirmation_tokens (confirmation_token, expired_date, user_id)
VALUES (null, null, 5);

INSERT INTO cinema.data (user_id, date, time, ip)
VALUES (1, 'December 31, 2021', '23:59', '127.0.0.1');
INSERT INTO cinema.data (user_id, date, time, ip)
VALUES (2, 'December 10, 2020', '05:00', '127.0.0.1');
INSERT INTO cinema.data (user_id, date, time, ip)
VALUES (2, 'December 19, 2020', '04:00', '127.0.0.1');
INSERT INTO cinema.data (user_id, date, time, ip)
VALUES (2, 'December 8, 2021', '03:00', '127.0.0.1');
INSERT INTO cinema.data (user_id, date, time, ip)
VALUES (2, 'December 5, 2022', '02:00', '127.0.0.1');

INSERT INTO cinema.images (user_id, file_name, size, mime, url)
VALUES (1, 'photo.png', '2MB', 'image/png', null);
INSERT INTO cinema.images (user_id, file_name, size, mime, url)
VALUES (2, 'avatar.jpg', '196KB', 'image/jpg', null);
INSERT INTO cinema.images (user_id, file_name, size, mime, url)
VALUES (2, 'image.png', '1MB', 'image/png', null);
INSERT INTO cinema.images (user_id, file_name, size, mime, url)
VALUES (3, 'my_holidays.jpg', '196KB', 'image/jpg', null);
INSERT INTO cinema.images (user_id, file_name, size, mime, url)
VALUES (4, 'dubai.png', '1MB', 'image/png', null);

INSERT INTO cinema.halls (serial_number, number_of_seats)
VALUES ('123D-435F-DF4F-2RFD', '35');
INSERT INTO cinema.halls (serial_number, number_of_seats)
VALUES ('3SDS-3244-DDF4-FD43', '30');
INSERT INTO cinema.halls (serial_number, number_of_seats)
VALUES ('A4DS-D678-8DS8-8DSD', '30');
INSERT INTO cinema.halls (serial_number, number_of_seats)
VALUES ('ASD4-435F-4464-DFF7', '25');
INSERT INTO cinema.halls (serial_number, number_of_seats)
VALUES ('AAA4-DDD4-4DDD-FFD6', '20');

INSERT INTO cinema.films (name, year_of_release, age_restrictions, description, poster_url)
VALUES ('Avatar 2', '2023', '12', 'Blue mans war.', null);
INSERT INTO cinema.films (name, year_of_release, age_restrictions, description, poster_url)
VALUES ('Cheburashka', '2023', '6', 'Family film.', null);
INSERT INTO cinema.films (name, year_of_release, age_restrictions, description, poster_url)
VALUES ('Transformers', '2012', '16', 'Auto-bots war.', null);
INSERT INTO cinema.films (name, year_of_release, age_restrictions, description, poster_url)
VALUES ('Astral', '2015', '18', 'Horror film.', null);
INSERT INTO cinema.films (name, year_of_release, age_restrictions, description, poster_url)
VALUES ('Terminator', '1984', '16', 'Robots war.', null);

INSERT INTO cinema.sessions (hall_id, film_id, date_time, ticket_cost)
VALUES (1, 1, '01/02/2023 20:00', '650');
INSERT INTO cinema.sessions (hall_id, film_id, date_time, ticket_cost)
VALUES (1, 2, '01/02/2023 23:00', '400');
INSERT INTO cinema.sessions (hall_id, film_id, date_time, ticket_cost)
VALUES (2, 1, '01/04/2023 14:00', '600');
INSERT INTO cinema.sessions (hall_id, film_id, date_time, ticket_cost)
VALUES (3, 3, '01/03/2023 20:00', '400');
INSERT INTO cinema.sessions (hall_id, film_id, date_time, ticket_cost)
VALUES (4, 4, '01/06/2023 01:00', '350');

INSERT INTO cinema.messages (film_id, author, content)
VALUES (1, 'user123', 'Hello!');
INSERT INTO cinema.messages (film_id, author, content)
VALUES (1, 'user435', 'Really good film :)');
INSERT INTO cinema.messages (film_id, author, content)
VALUES (1, 'user567', 'Bye (:');
INSERT INTO cinema.messages (film_id, author, content)
VALUES (2, 'user789', 'Cool film!');
INSERT INTO cinema.messages (film_id, author, content)
VALUES (3, 'user123', 'I do not like...');