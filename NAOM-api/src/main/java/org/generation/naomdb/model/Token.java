package org.generation.naomdb.model;

public class Token {

    private String accessToken;

    public Token(String accessToken) {
        this.accessToken = accessToken;
    }

    public Token() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
