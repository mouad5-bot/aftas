package com.example.aftas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Level cannot be null")
    private Long level;

    @NotBlank(message = "Description cannot be null")
    private String description;

    @NotNull(message = "Points cannot be null")
    private Long points;

    @OneToMany(mappedBy = "level")
    private List<Fish> fishes;
}
