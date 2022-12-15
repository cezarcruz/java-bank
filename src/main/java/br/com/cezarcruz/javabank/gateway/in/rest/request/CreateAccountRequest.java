package br.com.cezarcruz.javabank.gateway.in.rest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequest {

    private String agency;

    private String document;
}
