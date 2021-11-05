package com.project.sport.services;

import com.project.sport.models.Team;

import java.util.List;

public interface TeamService {

    List<Team> getAllTeams();

    Team update(Team team);

    void delete(Long id);

    Team add(Team team);

    Team findById(Long id);

}
