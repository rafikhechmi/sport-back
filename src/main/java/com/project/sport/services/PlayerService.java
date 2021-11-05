package com.project.sport.services;

import com.project.sport.models.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayers();

    Player update(Player player);

    void delete(Long id);

    Player add(Player player);

    Player findById(Long id);

}
