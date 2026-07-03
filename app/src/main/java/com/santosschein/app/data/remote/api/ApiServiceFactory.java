package com.santosschein.app.data.remote.api;

import retrofit2.Retrofit;

public final class ApiServiceFactory {

    private final Retrofit retrofit;

    public ApiServiceFactory(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public ReservationApi createReservationApi() {
        return retrofit.create(ReservationApi.class);
    }
}
