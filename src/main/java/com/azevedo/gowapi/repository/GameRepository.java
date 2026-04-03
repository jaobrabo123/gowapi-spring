package com.azevedo.gowapi.repository;

import com.azevedo.gowapi.model.Game;
import com.azevedo.gowapi.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, UUID> {

    List<Game> findByNameAndPlatform(String name, Platform platform);
    List<Game> findByName(String name);
    List<Game> findByPlatform(Platform platform);

}
