package com.example.demo_spring.stores;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testPlayerCreation() {
        Player player = new Player();
        player.setFullName("Лионель Месси");
        player.setPosition("Нападающий");
        player.setHeight(170);
        player.setWeight(72);

        assertEquals("Лионель Месси", player.getFullName());
        assertEquals("Нападающий", player.getPosition());
        assertEquals(170, player.getHeight());
        assertEquals(72, player.getWeight());
    }
}
