package com.example.demo_spring.stores.data;

import com.example.demo_spring.stores.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
public class JdbcPlayerRepositoryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsertAndQuery() {
        jdbcTemplate.update("DELETE FROM TEAM_PLAYER");
        jdbcTemplate.update("DELETE FROM Player");

        jdbcTemplate.update("INSERT INTO Player (full_name, position, height, weight, date_of_birth) VALUES (?, ?, ?, ?, ?)",
                "Лионель Месси", "Нападающий", 170, 72, Date.valueOf("1987-06-24"));

        int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Player", Integer.class);
        assertThat(count).isEqualTo(1);
    }
}

