package com.example.demo_spring.stores.web;


import com.example.demo_spring.stores.Player;
import com.example.demo_spring.stores.data.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/players")
public class PlayerController {

    private final PlayerRepository playerRepo;

    @Autowired
    public PlayerController(PlayerRepository playerRepo) {
        this.playerRepo = playerRepo;
    }

    @GetMapping
    public String listPlayers(Model model) {
        model.addAttribute("players", playerRepo.findAll());
        return "players/list";
    }

    @GetMapping("/new")
    public String newPlayerForm(Model model) {
        model.addAttribute("player", new Player());
        return "players/form";
    }

    @PostMapping
    public String savePlayer(@Valid Player player, Errors errors) {
        if (errors.hasErrors()) {
            return "players/form";
        }
        playerRepo.save(player);
        return "redirect:/players";
    }

    @GetMapping("/{id}/edit")
    public String editPlayerForm(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerRepo.findById(id).orElse(null));
        return "players/form";
    }

    @PostMapping("/{id}/delete")
    public String deletePlayer(@PathVariable Long id) {
        playerRepo.deleteById(id);
        return "redirect:/players";
    }
}