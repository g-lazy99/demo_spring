package com.example.demo_spring.stores.web;

import com.example.demo_spring.stores.data.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlayerController.class)
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerRepository playerRepo;

    @Test
    public void testListPlayers() throws Exception {
        mockMvc.perform(get("/players").with(user("testUser").roles("USER")))
                .andExpect(status().isOk())
                .andExpect(view().name("players/list"))
                .andExpect(model().attributeExists("players"));
    }
}
