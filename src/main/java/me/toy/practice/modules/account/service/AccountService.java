package me.toy.practice.modules.account.service;

import lombok.RequiredArgsConstructor;
import me.toy.practice.modules.account.controller.dto.AccountSaveDto;
import me.toy.practice.modules.account.domain.Account;
import me.toy.practice.modules.account.domain.repository.AccountRepository;
import me.toy.practice.modules.crew.domain.Crew;
import me.toy.practice.modules.crew.domain.repository.CrewRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final CrewRepository crewRepository;

    public Long saveAccount(AccountSaveDto saveDto) {
        Crew findCrew = crewRepository.findById(saveDto.getCrewId()).orElseThrow(() -> new IllegalArgumentException("crew id : " + saveDto.getCrewId()));
        Account saveAccount = saveDto.toEntity();
        saveAccount.addCrew(findCrew);
        return accountRepository.save(saveAccount).getId();
    }

    public void getAccounts(Pageable pageable) {
//        accountRepository.findAccountListDtos(pageable);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
