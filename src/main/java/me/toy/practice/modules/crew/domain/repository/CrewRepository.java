package me.toy.practice.modules.crew.domain.repository;

import me.toy.practice.modules.crew.domain.Crew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewRepository extends JpaRepository<Crew, Long> {
}
