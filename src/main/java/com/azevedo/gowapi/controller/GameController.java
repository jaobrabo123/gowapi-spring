package com.azevedo.gowapi.controller;

import com.azevedo.gowapi.model.Game;
import com.azevedo.gowapi.repository.GameRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private GameRepository gameRepository;

    public GameController(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @GetMapping
    public List<Game> find(){
        List<Game> games = gameRepository.findAll();
        return games;
    }

}
