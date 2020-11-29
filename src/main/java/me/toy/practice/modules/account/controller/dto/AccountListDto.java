package me.toy.practice.modules.account.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AccountListDto {

    private Long accountId;
    private String accountName;
    private String crewName;

    @Builder
    public AccountListDto(Long accountId, String accountName, String crewName) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.crewName = crewName;
    }
}