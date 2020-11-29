package me.toy.practice.modules.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.toy.practice.modules.account.controller.dto.AccountListDto;
import me.toy.practice.modules.account.controller.dto.AccountSaveDto;
import me.toy.practice.modules.account.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/account")
@RestController
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<?> saveAccount(@RequestBody @Valid AccountSaveDto saveDto, Errors errors) {
        // TODO Validation

        if (errors.hasErrors()) {
            ResponseEntity.badRequest();
        }

        Long savedId = accountService.saveAccount(saveDto);
        return ResponseEntity.ok(savedId);
    }

    @GetMapping
    public ResponseEntity<?> getAccounts(@PageableDefault(size = 10) Pageable pageable) {
        Page<AccountListDto> accounts = accountService.getAccounts(pageable);
        return ResponseEntity.ok(accounts);
    }
}
