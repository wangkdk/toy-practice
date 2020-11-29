package me.toy.practice.modules.account;

import me.toy.practice.common.BaseControllerTest;
import me.toy.practice.modules.account.controller.dto.AccountSaveDto;
import me.toy.practice.modules.crew.domain.Crew;
import me.toy.practice.modules.crew.domain.repository.CrewRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AccountControllerTest extends BaseControllerTest {

    @Autowired
    CrewRepository crewRepository;

    @Test
    @DisplayName("회원 저장")
    void saveAccount() throws Exception {
        // given
        Crew crew = Crew.builder()
                .name("test")
                .description("test crew")
                .build();
        Crew savedCrew = crewRepository.save(crew);

        AccountSaveDto account = AccountSaveDto.builder()
                .username("test")
                .password("test")
                .crewId(savedCrew.getId())
                .build();

        // when
        ResultActions result = mockMvc.perform(post("/account")
                .content(objectMapper.writeValueAsString(account))
                .contentType(MediaType.APPLICATION_JSON)
        );

        // then
        result.andDo(print())
                .andExpect(status().isOk());
    }

}