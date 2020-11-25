package me.toy.practice.modules.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public Long saveAccount(AccountSaveDto saveDto) {
        return accountRepository.save(saveDto.toEntity()).getId();
    }
}
