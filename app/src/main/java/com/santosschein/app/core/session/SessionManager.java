package com.santosschein.app.core.session;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class SessionManager {

    private static final String BEARER_PREFIX = "Bearer ";

    private final SessionStorage sessionStorage;

    public void saveAuthorizationHeader(String authorizationHeader) {
        if (authorizationHeader == null || authorizationHeader.trim().isEmpty()) {
            return;
        }

        String token = authorizationHeader.trim();
        if (token.regionMatches(true, 0, BEARER_PREFIX, 0, BEARER_PREFIX.length())) {
            token = token.substring(BEARER_PREFIX.length()).trim();
        }
        saveJwtToken(token);
    }

    public void saveJwtToken(String token) {
        if (token != null && !token.trim().isEmpty()) {
            sessionStorage.saveJwtToken(token.trim());
        }
    }

    public String getJwtToken() {
        return sessionStorage.getJwtToken();
    }

    public boolean hasActiveSession() {
        return sessionStorage.hasActiveSession();
    }

    public void clearSession() {
        sessionStorage.clear();
    }
}
