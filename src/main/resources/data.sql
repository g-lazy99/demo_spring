-- Удаление старых данных
DELETE FROM Tournament_Team;
DELETE FROM Tournament;
DELETE FROM Team_Player;
DELETE FROM Team;
DELETE FROM Player;

-- Игроки
INSERT INTO Player (full_name, position, date_of_birth, height, weight)
VALUES
    ('Лионель Месси', 'Нападающий', '1987-06-24', 170, 72),
    ('Криштиану Роналду', 'Нападающий', '1985-02-05', 187, 85),
    ('Мануэль Нойер', 'Вратарь', '1986-03-27', 193, 92);

-- Команды
INSERT INTO Team (name, coach, country, foundation_year)
VALUES
    ('Барселона', 'Шави', 'Испания', 1899),
    ('Манчестер Юнайтед', 'Эрик тен Хаг', 'Англия', 1878);

-- Связь игроков с командами
INSERT INTO Team_Player (team_id, player_id) VALUES (1, 1); -- Месси -> Барселона
INSERT INTO Team_Player (team_id, player_id) VALUES (2, 2); -- Роналду -> Манчестер Юнайтед

-- Турниры
INSERT INTO Tournament (name, date)
VALUES
    ('Лига Чемпионов', '2024-06-10');

-- Связь команд с турнирами
INSERT INTO Tournament_Team (tournament_id, team_id) VALUES (1, 1);
INSERT INTO Tournament_Team (tournament_id, team_id) VALUES (1, 2);

INSERT INTO users (username, password, role) VALUES ('admin', 'admin_password', 'ADMIN');
