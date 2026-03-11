package com.azevedo.gowapi.repository;

import com.azevedo.gowapi.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, UUID> {
}
