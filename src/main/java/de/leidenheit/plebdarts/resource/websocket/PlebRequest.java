package de.leidenheit.plebdarts.resource.websocket;

public interface PlebRequest {

    PlebMethod plebMethod();
    long clientId();
}
