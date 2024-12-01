package com.example.demo_spring.stores.data;

import com.example.demo_spring.stores.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepo;

    @BeforeEach
    void setup() {
        // Удаляем все записи перед каждым тестом, чтобы избежать конфликта данных
        playerRepo.deleteAll();
    }

    @Test
    public void testSaveAndFindAll() {
        Player player = new Player();
        player.setFullName("John Doe");
        player.setPosition("Forward");
        player.setHeight(180);
        player.setWeight(75);
        player.setDateOfBirth(LocalDate.of(1990, 1, 1)); // Используем LocalDate

        // Сохраняем игрока
        playerRepo.save(player);

    }

}
