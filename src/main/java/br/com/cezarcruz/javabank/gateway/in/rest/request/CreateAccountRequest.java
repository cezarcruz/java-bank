package br.com.cezarcruz.javabank.gateway.in.rest.request;

public record CreateAccountRequest(
    String agency,
    String document
) {}
