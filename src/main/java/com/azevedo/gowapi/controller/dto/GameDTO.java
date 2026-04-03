package com.azevedo.gowapi.controller.dto;

import com.azevedo.gowapi.model.Game;
import com.azevedo.gowapi.model.Platform;

import java.time.LocalDate;
import java.util.UUID;

public record GameDTO(
    UUID id,
    String name,
    String description,
    String history,
    LocalDate releaseDate,
    Platform platform
) {

    public Game mapToGame(){
        Game game = new Game();
        game.setName(this.name);
        game.setDescription(this.description);
        game.setHistory(this.history);
        game.setReleaseDate(this.releaseDate);
        game.setPlatform(this.platform);
        return game;
    }

}
