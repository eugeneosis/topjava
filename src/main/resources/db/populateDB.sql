DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_USER', 100000),
       ('ROLE_ADMIN', 100001);

INSERT INTO meals (datetime, description, calories, user_id)
VALUES ('2020-11-08 20:00:00', 'dinner', 1000,100000),
       ('2020-12-08 08:00:00', 'breakfast', 1000, 100000),
       ('2020-11-08 20:01:00', 'dinner', 1500, 100001),
       ('2020-12-08 08:01:00', 'breakfast', 1500, 100001);
