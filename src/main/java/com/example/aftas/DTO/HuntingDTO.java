package com.example.aftas.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HuntingDTO {
    private Long id;

    @NotNull(message = "Fish number cannot be null")
    private Long numberOfFish;

}
