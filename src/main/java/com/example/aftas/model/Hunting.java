package com.example.aftas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hunting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @NotBlank(message = "Fish number cannot be null")
    private int numberOfFish;

    @ManyToOne
    private Competition competition;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Fish fish;

}
