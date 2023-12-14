package com.example.aftas.DTO;

import com.example.aftas.model.embeddedKey.RankingKey;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
public class RankingDTO {

    private Long member_id;

    private String competition_code;

    @NotNull(message = "Rank cannot be null")
    private Long rank;

    @NotNull(message = "Score cannot be null")
    private Long score;
}
