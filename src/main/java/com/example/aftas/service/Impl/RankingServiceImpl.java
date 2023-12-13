package com.example.aftas.service.Impl;

import com.example.aftas.DTO.RankingDTO;
import com.example.aftas.model.Competition;
import com.example.aftas.model.Member;
import com.example.aftas.model.Ranking;
import com.example.aftas.model.embeddedKey.RankingKey;
import com.example.aftas.repository.CompetitionRepository;
import com.example.aftas.repository.MemberRepository;
import com.example.aftas.repository.RankingRepository;
import com.example.aftas.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {

    private final RankingRepository rankingRepository;
    private final CompetitionRepository competitionRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper mapper;
    @Override
    public RankingDTO add(RankingDTO rankingDTO) throws Exception {
        //checkDateOfParticipation(rankingDTO);
        //search for competition
        Competition competition = competitionRepository.findCompetitionByCode(rankingDTO.getCompetition_code());
        Member member = memberRepository.findById(rankingDTO.getMember_id()).orElseThrow(() -> new Exception(" no member with this code "));
        //serach for member
        // create new object for Ranking
        RankingKey rankingKey = RankingKey.builder()
                .code(rankingDTO.getCompetition_code())
                .num(rankingDTO.getMember_id())
                .build();
        Ranking ranking = Ranking.builder()
                .id(rankingKey)
                .rank(0L)
                .score(0L)
                .competition(competition)
                .member(member)
                .build();
       // Ranking ranking = mapper.map(rankingDTO, Ranking.class);
        Ranking saved = rankingRepository.save(ranking);
        return mapper.map(saved, RankingDTO.class);
    }

    private void checkDateOfParticipation(Ranking ranking) {

        LocalDate today = LocalDate.now();
        LocalDate competitionDate;

        if (ranking != null) {

            String code = ranking.getId().getCode();

            Competition competition = competitionRepository.findCompetitionByCode(code);

            if (competition != null) {
                competitionDate = competition.getDate();
            } else {
                throw new IllegalStateException("Competition is null");
            }
        } else {
            throw new IllegalArgumentException("Ranking is null or invalid");
        }

        if (!today.plusDays(1).isBefore(competitionDate)) {
            throw new IllegalArgumentException("Member cannot participate within 24 hours before the competition starts.");
        }
    }


    @Override
    public List<Ranking> getAll(Pageable pageable) {
        return null;
    }
}