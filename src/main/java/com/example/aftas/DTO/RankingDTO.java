package com.example.aftas.DTO;

import com.example.aftas.model.embeddedKey.RankingKey;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RankingDTO {
    private Long member_id;
    private String competition_code;
    private int rank;
    private int score;
}
