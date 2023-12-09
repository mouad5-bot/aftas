package com.example.aftas.DTO;

import com.example.aftas.model.embeddedKey.RankingKey;
import jakarta.validation.constraints.NotBlank;

public class RankingDTO {
    private RankingKey id;
    private int rank;
    private int score;
}
