package com.project.sport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sport.models.Player;




public interface PlayerRepository extends JpaRepository<Player, Long>{

}
