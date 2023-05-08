package br.com.cezarcruz.javabank.gateway.in.rest;

import br.com.cezarcruz.javabank.core.usecase.StartAccountCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CreateAccountEntrypoint.class)
class CreateAccountEntrypointTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StartAccountCreation startAccountCreation;

    @Test
    void shouldCreateAnAccount() throws Exception {

        doNothing().when(startAccountCreation).create(any());

        this.mockMvc.perform(post("/account")
                .content("""
                {
                    "agency": "123",
                    "document": "1234567"
                }
                """))
            .andDo(print())
            .andExpect(status().isCreated());

        verify(startAccountCreation).create(any());
    }

}