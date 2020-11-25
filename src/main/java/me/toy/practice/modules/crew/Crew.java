package me.toy.practice.modules.crew;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Crew {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = false)
    private String name;

    private String description;

    @Builder
    public Crew(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
