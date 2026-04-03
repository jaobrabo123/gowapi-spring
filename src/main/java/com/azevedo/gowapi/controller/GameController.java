package com.azevedo.gowapi.controller;

import com.azevedo.gowapi.controller.dto.ErrorDTO;
import com.azevedo.gowapi.controller.dto.GameDTO;
import com.azevedo.gowapi.exception.NotFoundException;
import com.azevedo.gowapi.model.Game;
import com.azevedo.gowapi.model.Platform;
import com.azevedo.gowapi.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody GameDTO gameDTO){
        Game created = gameService.create(gameDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteById(@PathVariable String id){
        try {
            gameService.deleteById(UUID.fromString(id));
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e){
            ErrorDTO errorDTO = ErrorDTO.notFoundResponse(e.getMessage());
            return ResponseEntity.status(errorDTO.status()).body(errorDTO);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable String id){
        try {
            GameDTO gameDTO = gameService.getById(UUID.fromString(id));
            return ResponseEntity.ok(gameDTO);
        } catch (NotFoundException e){
            ErrorDTO errorDTO = ErrorDTO.notFoundResponse(e.getMessage());
            return ResponseEntity.status(errorDTO.status()).body(errorDTO);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Platform platform
    ) {
        List<Game> games = gameService.getAll(name, platform);
        List<GameDTO> gameDTOs = games
                .stream()
                .map(g -> new GameDTO(g.getId(), g.getName(), g.getDescription(), g.getHistory(), g.getReleaseDate(), g.getPlatform()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(gameDTOs);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateById(@PathVariable String id, @RequestBody GameDTO dto){
        try{
            gameService.updateById(UUID.fromString(id), dto);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e){
            ErrorDTO errorDTO = ErrorDTO.notFoundResponse(e.getMessage());
            return ResponseEntity.status(errorDTO.status()).body(errorDTO);
        }
    }

}
