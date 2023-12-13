package com.example.aftas.model;

import com.example.aftas.model.embeddedKey.RankingKey;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ranking {
    @EmbeddedId
    private RankingKey id;

    @NotNull(message = "Rank cannot be null")
    private Long rank;

    @NotNull(message = "Score cannot be null")
    private Long score;

    @ManyToOne
    @MapsId("num")
    private Member member;

    @ManyToOne
    @MapsId("code")
    private Competition competition;
}
