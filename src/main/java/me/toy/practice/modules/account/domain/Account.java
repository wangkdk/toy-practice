package me.toy.practice.modules.account.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.toy.practice.modules.crew.domain.Crew;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crew_id")
    private Crew crew;

    public Account(String username, String password, Crew crew) {
        this.username = username;
        this.password = password;
        if (crew != null) {
            addCrew(crew);
        }
    }

    public void addCrew(Crew crew) {
        this.crew = crew;
        crew.getAccounts().add(this);
    }
}
