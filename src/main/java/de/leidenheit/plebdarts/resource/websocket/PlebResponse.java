package de.leidenheit.plebdarts.resource.websocket;

public interface PlebResponse<T> extends PlebRequest {

    T content();
}
