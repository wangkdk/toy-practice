package me.toy.practice.modules.crew.controller;

import me.toy.practice.common.BaseControllerTest;
import me.toy.practice.modules.crew.controller.dto.CrewSaveDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CrewControllerTest extends BaseControllerTest {

    @Test
    @DisplayName("crew 저장")
    void saveCrew() throws Exception {
        // given
        CrewSaveDto saveDto = CrewSaveDto.builder()
                .name("test")
                .description("test crew")
                .build();

        // when
        ResultActions result = mockMvc.perform(post("/crew")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(saveDto))
        );

        // then
        result.andDo(print())
                .andExpect(status().isOk());
    }
}