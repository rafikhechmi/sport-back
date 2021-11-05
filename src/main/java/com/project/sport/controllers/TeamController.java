package com.project.sport.controllers;

import com.project.sport.models.Team;
import com.project.sport.services.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PutMapping("/{id}")
    public Team update(@PathVariable Long id, @RequestBody Team team) {
        return teamService.update(team);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teamService.delete(id);
    }

    @PostMapping
    public Team add(@RequestBody Team team) {
        return teamService.add(team);
    }

    @GetMapping("/{id}")
    public Team getTeamsById(@PathVariable Long id) {
        return teamService.findById(id);
    }

}
