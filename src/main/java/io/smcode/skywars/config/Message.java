package io.smcode.skywars.config;

public enum Message {
    COMMAND_ONLY_FOR_PLAYERS("Command-Only-For-Players");

    private final String path;

    Message(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
