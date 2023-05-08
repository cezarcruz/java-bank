package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.core.usecase.GetAccountUseCase;
import br.com.cezarcruz.javabank.factory.AccountFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GetAccountEntrypoint.class)
class GetAccountEntrypointTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetAccountUseCase getAccountUseCase;

    @Test
    void shouldGetAll() throws Exception {

        when(getAccountUseCase.getAll())
            .thenReturn(Collections.singletonList(AccountFactory.generateActiveAccount()));

        this.mockMvc.perform(MockMvcRequestBuilders.get(new URI("/account")))
            .andExpect(status().isOk());
    }

}
