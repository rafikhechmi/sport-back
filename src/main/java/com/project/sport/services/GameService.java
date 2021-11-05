package com.project.sport.services;

import com.project.sport.models.Game;

import java.util.List;

public interface GameService {

    List<Game> getAllGames();

    Game update(Game game);

    void delete(Long id);

    Game add(Game game);

    Game findById(Long id);

}
