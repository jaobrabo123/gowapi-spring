package com.azevedo.gowapi.service;

import com.azevedo.gowapi.controller.dto.GameDTO;
import com.azevedo.gowapi.exception.NotFoundException;
import com.azevedo.gowapi.model.Game;
import com.azevedo.gowapi.model.Platform;
import com.azevedo.gowapi.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public Game create(GameDTO gameDTO){
        Game game = gameDTO.mapToGame();
        gameRepository.save(game);
        return game;
    }

    public void deleteById(UUID id){
        Optional<Game> game = gameRepository.findById(id);
        if(game.isEmpty()){
            throw new NotFoundException("Jogo não encontrado.");
        }
        gameRepository.delete(game.get());
    }

    public GameDTO getById(UUID id){
        Optional<Game> gameOptional = gameRepository.findById(id);
        if(gameOptional.isEmpty()){
            throw new NotFoundException("Jogo não encontrado.");
        }
        Game game = gameOptional.get();
        return new GameDTO(
                game.getId(),
                game.getName(),
                game.getDescription(),
                game.getHistory(),
                game.getReleaseDate(),
                game.getPlatform()
        );
    }

    public List<Game> getAll(String name, Platform platform){
        if(name != null && platform != null){
            return gameRepository.findByNameAndPlatform(name, platform);
        }
        if(name != null){
            return gameRepository.findByName(name);
        }
        if(platform != null){
            return gameRepository.findByPlatform(platform);
        }
        return gameRepository.findAll();
    }

    public void updateById(UUID id, GameDTO dto){
        Optional<Game> gameOptional = gameRepository.findById(id);
        if(gameOptional.isEmpty()){
            throw new NotFoundException("Jogo não encontrado.");
        }

        Game game = gameOptional.get();
        game.setName(dto.name());
        game.setPlatform(dto.platform());
        game.setHistory(dto.history());
        game.setReleaseDate(dto.releaseDate());
        game.setDescription(dto.description());

        gameRepository.save(game);
    }

}
