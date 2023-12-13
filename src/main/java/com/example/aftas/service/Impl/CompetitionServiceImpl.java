package com.example.aftas.service.Impl;

import com.example.aftas.handler.response.ApiResponse;
import com.example.aftas.model.Competition;
import com.example.aftas.repository.CompetitionRepository;
import com.example.aftas.service.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;

    @Override
    public Competition add(Competition competition) throws IllegalArgumentException {
        validationDate(competition);
        return competitionRepository.save(competition);
    }
    private void validationDate(Competition newCompetition) {
        LocalDate newCompetitionDate = newCompetition.getDate();

        Optional<Competition> competitionsOnSameDay = competitionRepository.findByDate(newCompetitionDate);

        if (competitionsOnSameDay.isPresent()){
            throw new IllegalArgumentException("You can have just one competition on the day.");
        }
    }

    @Override
    public List<Competition> findAll(Pageable pageable) {
        List<Competition> competitionList = competitionRepository.findAll(pageable).stream().toList();
        return competitionList;
    }
}
