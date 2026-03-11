package com.azevedo.gowapi.controller;

import com.azevedo.gowapi.model.Game;
import com.azevedo.gowapi.repository.GameRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/game")
public class GameController {

    private GameRepository gameRepository;

    public GameController(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @GetMapping
    public List<Game> findAll(){
        return gameRepository.findAll();
    }

    @GetMapping("{id}")
    public Game findById(@PathVariable("id") UUID id) {
        return gameRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") UUID id){
        gameRepository.deleteById(id);
    }

}
