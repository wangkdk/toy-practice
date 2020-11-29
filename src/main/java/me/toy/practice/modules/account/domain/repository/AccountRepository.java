package me.toy.practice.modules.account.domain.repository;

import me.toy.practice.modules.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
