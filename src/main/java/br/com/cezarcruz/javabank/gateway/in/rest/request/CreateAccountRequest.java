package br.com.cezarcruz.javabank.gateway.in.rest.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequest {
    @NotBlank
    private String agency;

    @NotBlank
    private String document;
}
