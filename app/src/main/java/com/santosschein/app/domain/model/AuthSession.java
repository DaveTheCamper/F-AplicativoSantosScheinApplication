package com.santosschein.app.domain.model;

public final class AuthSession {

    private final String jwtToken;
    private final User user;

    public AuthSession(String jwtToken, User user) {
        this.jwtToken = jwtToken;
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public User getUser() {
        return user;
    }
}
