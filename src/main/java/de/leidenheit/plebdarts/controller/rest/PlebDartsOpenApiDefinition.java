package de.leidenheit.plebdarts.controller.rest;

public interface PlebDartsOpenApiDefinition {
    // RFC9110, RFC7235; also see https://www.iana.org/assignments/http-authschemes/http-authschemes.xhtml;
    String AUTHENTICATION_SCHEME_BEARER = "bearer";
    String AUTHENTICATION_SCHEME_BASIC_AUTH = "basic";
}
