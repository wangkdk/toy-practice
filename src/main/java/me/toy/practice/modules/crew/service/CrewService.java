package me.toy.practice.modules.crew.service;

import lombok.RequiredArgsConstructor;
import me.toy.practice.modules.crew.controller.dto.CrewSaveDto;
import me.toy.practice.modules.crew.domain.Crew;
import me.toy.practice.modules.crew.domain.repository.CrewRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CrewService {

    private final CrewRepository crewRepository;

    public Long saveCrew(CrewSaveDto saveDto) {
        return crewRepository.save(saveDto.toEntity()).getId();
    }
}
