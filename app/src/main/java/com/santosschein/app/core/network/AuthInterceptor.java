package com.santosschein.app.core.network;

import androidx.annotation.NonNull;

import com.santosschein.app.core.session.SessionManager;

import java.io.IOException;

import lombok.RequiredArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@RequiredArgsConstructor
public final class AuthInterceptor implements Interceptor {

    private final SessionManager sessionManager;

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        String token = sessionManager.getJwtToken();

        if (token == null || token.trim().isEmpty()) {
            return chain.proceed(originalRequest);
        }

        Request authenticatedRequest = originalRequest.newBuilder()
                .addHeader("Authorization", "Bearer " + token)
                .build();
        Response response = chain.proceed(authenticatedRequest);
        if (response.code() == 401) {
            sessionManager.clearSession();
        }
        return response;
    }
}
