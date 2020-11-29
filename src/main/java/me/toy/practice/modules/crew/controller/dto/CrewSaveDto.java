package me.toy.practice.modules.crew.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.toy.practice.modules.crew.domain.Crew;

@NoArgsConstructor
@Getter
public class CrewSaveDto {

    private String name;
    private String description;

    @Builder
    public CrewSaveDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Crew toEntity() {
        return Crew.builder()
                .name(name)
                .description(description)
                .build();
    }
}
