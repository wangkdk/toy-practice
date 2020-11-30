package me.toy.practice.modules.account.domain.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import me.toy.practice.modules.account.controller.dto.AccountListDto;
import me.toy.practice.modules.account.controller.dto.QAccountListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;

import java.util.Set;
import java.util.stream.Collectors;

import static me.toy.practice.modules.account.domain.QAccount.account;
import static me.toy.practice.modules.crew.domain.QCrew.crew;

public class AccountRepositoryImpl implements AccountRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public AccountRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<AccountListDto> findAccountListDtos(Pageable pageable) {
//        QueryResults<AccountListDto> results = queryFactory
//                .select(new QAccountListDto(
//                        account.id.as("accountId"),
//                        account.username.as("accountName"),
//                        crew.name.as("crewName")
//                ))
//                .from(account)
//                .join(account.crew, crew)
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetchResults();

        JPAQuery<AccountListDto> query = queryFactory
                .select(new QAccountListDto(
                        account.id.as("accountId"),
                        account.username.as("accountName"),
                        crew.name.as("crewName")
                ))
                .from(account)
                .join(account.crew, crew);

        for (Sort.Order order : pageable.getSort()) {
//            if (order.getProperty().equals("username")) {
//                if (order.getDirection().isAscending()) {
//                    query.orderBy(account.username.asc());
//                } else {
//                    query.orderBy(account.username.desc());
//                }
//            }
//
//            if (order.getProperty().equals("id")) {
//                if (order.getDirection().isAscending()) {
//                    query.orderBy(account.id.asc());
//                } else {
//                    query.orderBy(account.id.desc());
//                }
//            }
            PathBuilder pathBuilder = new PathBuilder(account.getType(), account.getMetadata());
            query.orderBy(new OrderSpecifier(order.isAscending() ? Order.ASC : Order.DESC, pathBuilder.get(order.getProperty())));
        }

        QueryResults<AccountListDto> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }
}
