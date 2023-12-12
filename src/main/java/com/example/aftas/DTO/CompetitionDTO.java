package com.example.aftas.DTO;

import com.example.aftas.model.Competition;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompetitionDTO {
    private String code;

    private String date;

    private String startTime;

    private String endTime;

    private int numberOfParticipants;

    private String location;

    private int amountOfFish;
}