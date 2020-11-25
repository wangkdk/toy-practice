package me.toy.practice.modules.account;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
