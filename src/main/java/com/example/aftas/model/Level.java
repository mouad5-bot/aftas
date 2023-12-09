package com.example.aftas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @NotBlank(message = "Level cannot be null")
    private int level;

    @NotBlank(message = "Description cannot be null")
    private String description;

    @NotBlank(message = "Points cannot be null")
    private int points;

    @OneToMany(mappedBy = "level")
    private List<Fish> fishes;
}
