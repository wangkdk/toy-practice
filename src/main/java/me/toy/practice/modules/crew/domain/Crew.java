package me.toy.practice.modules.crew.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.toy.practice.modules.account.domain.Account;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Crew {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "crew")
    private List<Account> accounts = new ArrayList<>();

    @Builder
    public Crew(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
