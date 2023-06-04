package br.com.cezarcruz.javabank.gateway.in.rest.mappers;

import br.com.cezarcruz.javabank.core.domain.Account;
import br.com.cezarcruz.javabank.gateway.in.rest.request.CreateAccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountMapper {

    Account from(final CreateAccountRequest accountRequest);

}
