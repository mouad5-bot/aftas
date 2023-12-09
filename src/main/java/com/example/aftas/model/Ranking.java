package com.example.aftas.model;

import com.example.aftas.model.embeddedKey.RankingKey;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ranking {
    @EmbeddedId
    @Column(unique = true)
    private RankingKey id;

    @NotBlank(message = "Rank cannot be null")
    private int rank;

    @NotBlank(message = "Score cannot be null")
    private int score;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Competition competition;
}
