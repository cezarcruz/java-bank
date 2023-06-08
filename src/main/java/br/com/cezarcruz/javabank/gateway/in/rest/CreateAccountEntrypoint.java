package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.core.usecase.StartAccountCreation;
import br.com.cezarcruz.javabank.gateway.in.rest.mappers.AccountMapper;
import br.com.cezarcruz.javabank.gateway.in.rest.request.CreateAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class CreateAccountEntrypoint {

    private final StartAccountCreation startAccountCreation;
    private final AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<Void> create(final CreateAccountRequest request) {

        final var account = accountMapper.from(request);

        startAccountCreation.create(account);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

}
