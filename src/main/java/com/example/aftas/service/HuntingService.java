package com.example.aftas.service;

import com.example.aftas.DTO.HuntingDTO;
import com.example.aftas.DTO.RankingDTO;
import com.example.aftas.DTO.SaveHuntDTO;
import com.example.aftas.model.Hunting;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HuntingService {
    SaveHuntDTO add(SaveHuntDTO hunting) throws Exception;
    public List<HuntingDTO> findAll(Pageable pageable);
}
