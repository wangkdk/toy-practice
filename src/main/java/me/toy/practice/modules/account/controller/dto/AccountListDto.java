package me.toy.practice.modules.account.controller.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class AccountListDto {

    private Long accountId;
    private String accountName;
    private String crewName;
    private Long createdBy;
    private LocalDateTime updatedDate;

    @QueryProjection
    public AccountListDto(Long accountId, String accountName, String crewName, Long createdBy, LocalDateTime updatedDate) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.crewName = crewName;
        this.createdBy = createdBy;
        this.updatedDate = updatedDate;
    }
}
