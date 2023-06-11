package br.com.cezarcruz.javabank.gateway.out.mongo.mapper;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.out.mongo.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountEntityMapper {

    AccountEntity from(final Account account);
    Account to(final AccountEntity accountEntity);

}
