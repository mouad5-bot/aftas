package com.example.aftas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Competition {
    @Id
    private String code;

    @NotNull(message = "Date of competition cannot be null")
    private LocalDate date;

    @NotNull(message = "Start time cannot be null")
    private LocalTime startTime;

    @NotNull(message = "End time cannot be null")
    private LocalTime endTime;

    @NotNull(message = "Participants number cannot be null")
    private Long numberOfParticipants;

    @NotBlank(message = "Location cannot be null")
    private String location;

    @NotNull(message = "Amount of fish cannot be null")
    private Long amountOfFish;


    @OneToMany(mappedBy = "competition")
    private List<Ranking> rankingList;

    @OneToMany(mappedBy = "competition")
    private List<Hunting> huntingList;
}
