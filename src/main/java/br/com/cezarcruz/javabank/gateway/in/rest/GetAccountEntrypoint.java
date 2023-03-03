package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.core.usecase.GetAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class GetAccountEntrypoint {

    private final GetAccountUseCase getAccountUseCase;

    @GetMapping("/{internalId}")
    public ResponseEntity<Account> getBy(final String internalId) {
        return getAccountUseCase.getBy(internalId)
            .map(ResponseEntity::ok)
            .orElseThrow();
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(getAccountUseCase.getAll());
    }
}

