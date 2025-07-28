package io.smcode.skywars.config;

public enum Message {
    COMMAND_ONLY_FOR_PLAYERS("Command-Only-For-Players"),
    GAME_CREATED("Game-Created"),
    ENTITY_NOT_FOUND("Entity-Not-Found"),
    ENTITY_UPDATED("Entity-Updated");

    private final String path;

    Message(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
