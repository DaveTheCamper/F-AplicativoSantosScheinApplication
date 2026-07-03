package com.santosschein.app.core.network;

import com.santosschein.app.core.config.AppConfig;
import com.santosschein.app.core.session.SessionStorage;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitClientFactory {

    private RetrofitClientFactory() {
    }

    public static Retrofit create(AppConfig appConfig, SessionStorage sessionStorage) {
        return new Retrofit.Builder()
                .baseUrl(appConfig.getApiBaseUrl())
                .client(OkHttpClientFactory.create(sessionStorage))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
