package com.azevedo.gowapi.repository;

import com.azevedo.gowapi.model.Caracter;
import com.azevedo.gowapi.model.Game;
import com.azevedo.gowapi.model.GameCaracter;
import com.azevedo.gowapi.model.Platform;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class GameRepositoryTest {

    @Autowired
    GameRepository gameRepository;

    @Test
    public void criarTest(){
        Game game = new Game();
        game.setName("Teste");
        game.setDescription("Descrição teste");
        game.setHistory("História teste");
        game.setPlatform(Platform.PS5);
        game.setReleaseDate(LocalDate.of(2000, 6, 19));
        gameRepository.save(game);
    }

    @Test
    public void buscarTest(){
        UUID id = UUID.fromString("1b764409-80ab-4cd3-99ba-f01ee3f5e9f7");
        Optional<Game> game = gameRepository.findById(id);
        if (game.isPresent()){
            System.out.println(game.get());
        } else {
            System.out.println("Não Encontrado");
        }
    }

    @Test
    public void deletarTest(){
        UUID id = UUID.fromString("a2955189-e3c3-4a67-800c-93f9f595e360");
        Optional<Game> game = gameRepository.findById(id);
        if (game.isPresent()){
            gameRepository.delete(game.get());
        } else {
            System.out.println("Não Encontrado");
        }
    }

    @Test
    public void criarComPersonagens(){
        Game game = new Game();
        game.setName("Teste");
        game.setDescription("Descrição teste");
        game.setHistory("História teste");
        game.setPlatform(Platform.PS5);
        game.setReleaseDate(LocalDate.of(2000, 6, 19));

        Caracter caracter = new Caracter();
        caracter.setName("Teste");
        caracter.setHistory("História teste");

        GameCaracter gameCaracter = new GameCaracter();
        gameCaracter.setGame(game);
        gameCaracter.setCaracter(caracter);

        game.setGameCaracters(List.of(gameCaracter));

        Game savedGame = gameRepository.save(game);

        System.out.println(savedGame);
    }

}