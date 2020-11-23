package me.toy.practice.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class AuditConfig {

    @Bean
    public AuditorAware<Long> auditorProvider() {
        // TODO security 적용 후 SecurityContextHolder 에서 꺼내자
        return () -> Optional.of(1L);
    }
}
