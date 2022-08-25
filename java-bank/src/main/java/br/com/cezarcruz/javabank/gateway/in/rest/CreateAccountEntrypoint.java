package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.usecase.StartAccountCreation;
import br.com.cezarcruz.javabank.gateway.in.rest.request.CreateAccountRequest;
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
public class CreateAccountEntrypoint {


    private final StartAccountCreation startAccountCreation;

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody final CreateAccountRequest request) {

        final Account account =
                Account.builder()
                        .agency(request.getAgency())
                        .build();

        startAccountCreation.create(account);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }

}
