package com.project.sport.controllers;

import com.project.sport.models.Player;
import com.project.sport.services.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("")
    public List<Player> getAllMatches() {
        return playerService.getAllPlayers();
    }

    @PutMapping("/{id}")
    public Player update(@PathVariable Long id, @RequestBody Player player) {
        return playerService.update(player);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerService.delete(id);
    }

    @PostMapping
    public Player add(@RequestBody Player player) {
        return playerService.add(player);
    }

    @GetMapping("/{id}")
    public Player getPlayersById(@PathVariable Long id) {
        return playerService.findById(id);
    }

}
