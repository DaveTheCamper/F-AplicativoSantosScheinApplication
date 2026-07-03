package com.santosschein.app.core.network;

import com.santosschein.app.BuildConfig;
import com.santosschein.app.core.session.SessionStorage;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public final class OkHttpClientFactory {

    private OkHttpClientFactory() {
    }

    public static OkHttpClient create(SessionStorage sessionStorage) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG
                ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);

        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new AuthInterceptor(sessionStorage))
                .addInterceptor(loggingInterceptor)
                .build();
    }
}
