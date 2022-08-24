package br.com.cezarcruz.javabank.core.rest;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.rest.request.CreateAccountRequest;
import br.com.cezarcruz.javabank.core.usecase.CreateAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class CreateAccountController {

    private final CreateAccountUseCase createAccountUseCase;

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody final CreateAccountRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createAccountUseCase.create(request.getAgency()));
    }

}
