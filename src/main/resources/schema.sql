-- Таблица игроков
CREATE TABLE IF NOT EXISTS Player (
                                      id BIGSERIAL PRIMARY KEY,
                                      full_name VARCHAR(100) NOT NULL,
                                      position VARCHAR(50) NOT NULL,
                                      date_of_birth DATE NOT NULL,
                                      height INT NOT NULL,
                                      weight INT NOT NULL
);

-- Таблица команд
CREATE TABLE IF NOT EXISTS Team (
                                    id BIGSERIAL PRIMARY KEY,
                                    name VARCHAR(50) NOT NULL,
                                    coach VARCHAR(50) NOT NULL,
                                    country VARCHAR(50) NOT NULL,
                                    foundation_year INT NOT NULL
);

-- Связь между командами и игроками
CREATE TABLE IF NOT EXISTS Team_Player (
                                           team_id BIGINT NOT NULL,
                                           player_id BIGINT NOT NULL,
                                           PRIMARY KEY (team_id, player_id),
                                           FOREIGN KEY (team_id) REFERENCES Team(id),
                                           FOREIGN KEY (player_id) REFERENCES Player(id)
);

-- Таблица турниров
CREATE TABLE IF NOT EXISTS Tournament (
                                          id BIGSERIAL PRIMARY KEY,
                                          name VARCHAR(100) NOT NULL,
                                          date DATE NOT NULL
);

-- Связь между турнирами и командами
CREATE TABLE IF NOT EXISTS Tournament_Team (
                                               tournament_id BIGINT NOT NULL,
                                               team_id BIGINT NOT NULL,
                                               PRIMARY KEY (tournament_id, team_id),
                                               FOREIGN KEY (tournament_id) REFERENCES Tournament(id),
                                               FOREIGN KEY (team_id) REFERENCES Team(id)
);

CREATE TABLE IF NOT EXISTS users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       role VARCHAR(20) NOT NULL
);
