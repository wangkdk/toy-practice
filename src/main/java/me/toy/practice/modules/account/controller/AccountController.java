package me.toy.practice.modules.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.toy.practice.modules.account.controller.dto.AccountSaveDto;
import me.toy.practice.modules.account.service.AccountService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<?> getAccounts(@PageableDefault(size = 10)Pageable pageable) {
        Sort sort = pageable.getSort();
        sort.forEach(s -> {
            log.info("s : {}", s);
            log.info("s.getProperty : {}", s.getProperty());
            log.info("s.getDirection : {}", s.getDirection());
        });
        log.info("sort : {}", sort);
        return ResponseEntity.ok("ok");
    }
}
