package com.azevedo.gowapi.repository;

import com.azevedo.gowapi.model.Caracter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class CaracterRepositoryTest {

    @Autowired
    CaracterRepository caracterRepository;

    @Test
    public void criarTest(){
        Caracter caracter = new Caracter();
        caracter.setName("Teste");
        caracter.setHistory("História teste");
        caracterRepository.save(caracter);
        System.out.println(caracter);
    }

    @Test
    public void buscarTest(){
        UUID id = UUID.fromString("121406f3-5903-4f97-8db7-175c4ba7929c");
        Optional<Caracter> caracter = caracterRepository.findById(id);
        if (caracter.isPresent()){
            System.out.println(caracter.get());
        } else {
            System.out.println("Não Encontrado");
        }
    }

    @Test
    public void deletarTest(){
        UUID id = UUID.fromString("121406f3-5903-4f97-8db7-175c4ba7929c");
        Optional<Caracter> caracter = caracterRepository.findById(id);
        if (caracter.isPresent()){
            caracterRepository.delete(caracter.get());
        } else {
            System.out.println("Não Encontrado");
        }
    }

}