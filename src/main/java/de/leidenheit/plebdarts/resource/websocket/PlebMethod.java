package de.leidenheit.plebdarts.resource.websocket;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Protocol methods for the websocket communication.
 */
@AllArgsConstructor
@Getter
public enum PlebMethod {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // server related
    /**
     * Indicates to establish a new websocket connection.
     */
    CONNECT(1001, ""),

    /**
     * Indicates to close an existing websocket connection.
     */
    DISCONNECT(1002, ""),

    /**
     * Broadcast failures withing a websocket session.
     */
    ERROR(5000, ""),

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // game related
    /**
     * Indicates to create a new pleb dart game for a websocket session.
     */
    CREATE_GAME(2001, ""),

    /**
     * Indicates to delete an existing pleb dart game for a websocket session.
     */
    CLOSE_GAME(2002, ""),

    /**
     * Indicates to update an existing pleb dart game for a websocket session.
     */
    UPDATE_GAME(2003, ""),

    /**
     * Indicates to join an existing pleb dart game for a websocket session.
     */
    JOIN_GAME(2004, ""),

    /**
     * Indicates to leave an existing pleb dart game for a websocket session.
     */
    LEAVE_GAME(2005, "");

    private final int code;
    private final String alias;
}
