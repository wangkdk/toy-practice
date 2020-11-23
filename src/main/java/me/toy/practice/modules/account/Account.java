package me.toy.practice.modules.account;

import lombok.Getter;
import me.toy.practice.infra.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Account extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
}
