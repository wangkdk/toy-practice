package me.toy.practice.modules.account.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.toy.practice.modules.account.domain.Account;

@NoArgsConstructor
@Getter
public class AccountSaveDto {

    private String username;
    private String password;

    @Builder
    public AccountSaveDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account toEntity() {
        return Account.builder()
                .username(username)
                .password(password)
                .build();
    }
}
