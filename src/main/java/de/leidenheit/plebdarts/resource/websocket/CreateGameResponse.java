package de.leidenheit.plebdarts.resource.websocket;

import de.leidenheit.plebdarts.resource.websocket.game.GameData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class CreateGameResponse implements PlebResponse<GameData> {

    private long clientId;
    private GameData content;

    @Override
    public PlebMethod plebMethod() {
        return PlebMethod.CREATE_GAME;
    }

    @Override
    public long clientId() {
        return clientId;
    }

    @Override
    public GameData content() {
        return content;
    }
}
