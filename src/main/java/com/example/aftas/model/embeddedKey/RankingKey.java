package com.example.aftas.model.embeddedKey;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class RankingKey implements Serializable {
    private String code;
    private Long num;
}
