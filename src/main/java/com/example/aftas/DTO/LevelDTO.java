package com.example.aftas.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LevelDTO {
    private Long id;

    @NotNull(message = "Level cannot be null")
    private Long level;

    @NotBlank(message = "Description cannot be null")
    private String description;

    @NotNull(message = "Points cannot be null")
    private Long points;

}
