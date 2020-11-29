package me.toy.practice.modules.crew.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.toy.practice.modules.crew.controller.dto.CrewSaveDto;
import me.toy.practice.modules.crew.service.CrewService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/crew")
@RestController
public class CrewController {

    private final CrewService crewService;

    @PostMapping
    public ResponseEntity<?> saveCrew(@RequestBody @Valid CrewSaveDto crewSaveDto, Errors errors) {
        if (errors.hasErrors()) {
            ResponseEntity.badRequest();
        }

        Long savedId = crewService.saveCrew(crewSaveDto);
        return ResponseEntity.ok(savedId);
    }
}
