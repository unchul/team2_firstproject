
CREATE DATABASE IF NOT EXISTS reservation_system;
USE reservation_system;

CREATE TABLE IF NOT EXISTS reservation (
  reservation_key INT PRIMARY KEY,
  lodging_num INT NOT NULL,
  lodging_room VARCHAR(20) NOT NULL,
  reservation_date DATE NOT NULL,
  user_id INT NOT NULL,
  guest INT NOT NULL,
  reservation_period INT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO reservation (reservation_key, lodging_num, lodging_room, reservation_date, user_id, guest, reservation_period) VALUES (1, 5, '05_01', '2025-05-27', 1, 2, 2);
INSERT INTO reservation (reservation_key, lodging_num, lodging_room, reservation_date, user_id, guest, reservation_period) VALUES (2, 2, '02_02', '2025-06-04', 2, 6, 1);
INSERT INTO reservation (reservation_key, lodging_num, lodging_room, reservation_date, user_id, guest, reservation_period) VALUES (3, 18, '18_02', '2025-04-25', 3, 4, 3);
INSERT INTO reservation (reservation_key, lodging_num, lodging_room, reservation_date, user_id, guest, reservation_period) VALUES (4, 14, '14_01', '2024-10-31', 4, 2, 1);
INSERT INTO reservation (reservation_key, lodging_num, lodging_room, reservation_date, user_id, guest, reservation_period) VALUES (5, 21, '21_01', '2024-12-10', 5, 3, 4);
INSERT INTO reservation (reservation_key, lodging_num, lodging_room, reservation_date, user_id, guest, reservation_period) VALUES (6, 18, '18_02', '2025-05-24', 6, 5, 1);
INSERT INTO reservation (reservation_key, lodging_num, lodging_room, reservation_date, user_id, guest, reservation_period) VALUES (7, 22, '22_01', '2025-02-01', 7, 4, 2);
INSERT INTO reservation (reservation_key, lodging_num, lodging_room, reservation_date, user_id, guest, reservation_period) VALUES (8, 30, '30_02', '2025-01-29', 8, 2, 1);
INSERT INTO reservation (reservation_key, lodging_num, lodging_room, reservation_date, user_id, guest, reservation_period) VALUES (9, 29, '29_01', '2024-04-25', 9, 3, 3);
INSERT INTO reservation (reservation_key, lodging_num, lodging_room, reservation_date, user_id, guest, reservation_period) VALUES (10, 7, '07_02', '2025-05-28', 10, 5, 2);
