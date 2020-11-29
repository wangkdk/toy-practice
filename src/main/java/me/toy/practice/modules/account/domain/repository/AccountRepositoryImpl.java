package me.toy.practice.modules.account.domain.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import me.toy.practice.modules.account.controller.dto.AccountListDto;
import me.toy.practice.modules.account.controller.dto.QAccountListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

import static me.toy.practice.modules.account.domain.QAccount.account;
import static me.toy.practice.modules.crew.domain.QCrew.crew;

public class AccountRepositoryImpl implements AccountRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public AccountRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<AccountListDto> findAccountListDtos(Pageable pageable) {
        QueryResults<AccountListDto> results = queryFactory
                .select(new QAccountListDto(
                        account.id.as("accountId"),
                        account.username.as("accountName"),
                        crew.name.as("crewName")
                ))
                .from(account)
                .join(account.crew, crew)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }
}
