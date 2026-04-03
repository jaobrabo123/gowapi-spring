package com.azevedo.gowapi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "game_character")
@Data
@EntityListeners(AuditingEntityListener.class)
public class GameCaracter {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @CreatedDate
    @Column(name = "created_at")
    private Instant createdAt;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinColumn(name = "character_id", nullable = false)
    private Caracter caracter;

}
