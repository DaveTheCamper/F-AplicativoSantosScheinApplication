package com.santosschein.app.core.network;

import androidx.annotation.NonNull;

import com.santosschein.app.core.session.SessionStorage;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public final class AuthInterceptor implements Interceptor {

    private final SessionStorage sessionStorage;

    public AuthInterceptor(SessionStorage sessionStorage) {
        this.sessionStorage = sessionStorage;
    }

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        String token = sessionStorage.getJwtToken();

        if (token == null || token.trim().isEmpty()) {
            return chain.proceed(originalRequest);
        }

        Request authenticatedRequest = originalRequest.newBuilder()
                .addHeader("Authorization", "Bearer " + token)
                .build();
        return chain.proceed(authenticatedRequest);
    }
}
