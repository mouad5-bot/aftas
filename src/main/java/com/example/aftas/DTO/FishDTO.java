package com.example.aftas.DTO;

import com.example.aftas.model.Hunting;
import com.example.aftas.model.Level;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FishDTO {

    private Long id;
    @NotBlank(message = "Name cannot be null")
    private String name;
    @NotNull(message = "average Weight  cannot be null")
    private double averageWeight;

}
