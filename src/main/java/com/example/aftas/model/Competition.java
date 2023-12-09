package com.example.aftas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private String code;

    @NotBlank(message = "Date cannot be null")
    private String date;

    @NotBlank(message = "Start date cannot be null")
    private String startTime;

    @NotBlank(message = "End date cannot be null")
    private String endTime;

    @NotBlank(message = "Participants number cannot be null")
    private int numberOfParticipants;

    @NotBlank(message = "Location cannot be null")
    private String location;

    @NotBlank(message = "Amount of fish cannot be null")
    private int amountOfFish;


    @OneToMany(mappedBy = "competition")
    private List<Ranking> rankingList;

    @OneToMany(mappedBy = "competition")
    private List<Hunting> huntingList;
}
