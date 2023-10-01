package br.com.cezarcruz.javabank.gateway.out.mongo.entity;

import br.com.cezarcruz.javabank.core.domain.AccountStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("account")
public record AccountEntity(
        @Id String id,

        @Indexed
        String internalId,

        @Indexed
        String document,
        Integer accountNumber,
        String agency,
        AccountStatus status
) {}
