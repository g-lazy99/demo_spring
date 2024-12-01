package com.example.demo_spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/football")
public class FootballController {

    // Обработчик для домашней страницы
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // Обработчик для страницы "Команды"
    @GetMapping("/teams")
    public String teams() {
        return "teams";
    }

    // Обработчик для страницы "Игроки"
    @GetMapping("/players")
    public String players() {
        return "players";
    }
}
