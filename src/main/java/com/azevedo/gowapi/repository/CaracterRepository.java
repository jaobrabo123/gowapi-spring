package com.azevedo.gowapi.repository;

import com.azevedo.gowapi.model.Caracter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CaracterRepository extends JpaRepository<Caracter, UUID> {
}
