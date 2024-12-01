package com.example.demo_spring.stores.web;

import com.example.demo_spring.Team;
import com.example.demo_spring.stores.data.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/teams")
public class TeamController {

    private final TeamRepository teamRepo;

    @Autowired
    public TeamController(TeamRepository teamRepo) {
        this.teamRepo = teamRepo;
    }

    @GetMapping
    public String listTeams(Model model) {
        model.addAttribute("teams", teamRepo.findAll());
        return "teams/list";
    }

    @GetMapping("/new")
    public String newTeamForm(Model model) {
        model.addAttribute("team", new Team());
        return "teams/form";
    }

    @PostMapping
    public String saveTeam(@Valid Team team, Errors errors) {
        if (errors.hasErrors()) {
            return "teams/form";
        }
        teamRepo.save(team);
        return "redirect:/teams";
    }

    @GetMapping("/{id}/edit")
    public String editTeamForm(@PathVariable Long id, Model model) {
        model.addAttribute("team", teamRepo.findById(id).orElse(null));
        return "teams/form";
    }

    @PostMapping("/{id}/delete")
    public String deleteTeam(@PathVariable Long id) {
        teamRepo.deleteById(id);
        return "redirect:/teams";
    }
}
