package me.toy.practice.modules.account.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import me.toy.practice.modules.account.controller.dto.AccountListDto;
import me.toy.practice.modules.account.controller.dto.QAccountListDto;
import me.toy.practice.modules.account.domain.QAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

import static me.toy.practice.modules.account.domain.QAccount.*;

public class AccountRepositoryImpl implements AccountRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public AccountRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<AccountListDto> findAccountListDtos(Pageable pageable) {
//        queryFactory
//                .select(new QAccountListDto(
//                        account.id, account.username
//                ))

        return null;
    }
}
