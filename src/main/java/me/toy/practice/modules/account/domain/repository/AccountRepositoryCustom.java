package me.toy.practice.modules.account.domain.repository;

import me.toy.practice.modules.account.controller.dto.AccountListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountRepositoryCustom {
    Page<AccountListDto> findAccountListDtos(Pageable pageable);
}
