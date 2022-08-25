package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.usecase.GetAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class GetAccountEntrypoint {

    private final GetAccountUseCase getAccountUseCase;

    @GetMapping("/{internalId}")
    public ResponseEntity<Account> getBy(@PathVariable final String internalId) {

        final Optional<Account> account = getAccountUseCase.getBy(internalId);

        return account
                .map(ResponseEntity::ok)
                .orElseThrow(RuntimeException::new);
    }

}
