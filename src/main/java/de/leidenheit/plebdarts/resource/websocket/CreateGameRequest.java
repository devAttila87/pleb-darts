package de.leidenheit.plebdarts.resource.websocket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class CreateGameRequest implements PlebRequest {

    private long sessionId;

    @Override
    public PlebMethod plebMethod() {
        return PlebMethod.CREATE_GAME;
    }

    @Override
    public long clientId() {
        return sessionId;
    }
}
