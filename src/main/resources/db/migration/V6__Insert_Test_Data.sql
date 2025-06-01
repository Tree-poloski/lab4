-- 1. Сначала добавь роли
INSERT INTO roles (role_id, role_name) VALUES
(1, 'user'),
(2, 'admin');

-- 2. Вставь пользователей, сразу с нужными ролями
INSERT INTO users (user_id, first_name, last_name, username, password, created_at, role) VALUES
(1, 'John', 'Doe', 'johndoe', 'password123', NOW(), 2),
(2, 'Jane', 'Smith', 'janesmith', 'password456', NOW(), 2),
(3, 'Alice', 'Brown', 'alicebrown', 'password789', NOW(), 1),
(4, 'Bob', 'White', 'bobwhite', 'password000', NOW(), 1);

-- 3. Вставь города
INSERT INTO city (city_id, display_name, created_at) VALUES
(1, 'Kyiv', NOW()),
(2, 'Kharkib', NOW()),
(3, 'Odessa', NOW()),
(4, 'Lviv', NOW());

-- 4. Вставь рейсы
INSERT INTO flight (flight_id, departure_time, arrival_time, flight_number, price, created_at, departure_city_id, arrival_city_id) VALUES
(1, NOW(), NOW() + INTERVAL '2 hours', 1001, 200.00, NOW(), 1, 2),
(2, NOW() + INTERVAL '1 day', NOW() + INTERVAL '1 day 3 hours', 1002, 300.50, NOW(), 2, 3),
(3, NOW() + INTERVAL '2 days', NOW() + INTERVAL '2 days 4 hours', 1003, 150.75, NOW(), 3, 4),
(4, NOW() + INTERVAL '3 days', NOW() + INTERVAL '3 days 5 hours', 1004, 400.00, NOW(), 4, 1);

-- 5. Вставь билеты
INSERT INTO ticket (ticket_id, flight_id, user_id, pnr, created_at) VALUES
(1, 1, 1, 'PNR12345', NOW()),
(2, 2, 2, 'PNR67890', NOW()),
(3, 3, 3, 'PNR54321', NOW()),
(4, 4, 4, 'PNR09876', NOW());
