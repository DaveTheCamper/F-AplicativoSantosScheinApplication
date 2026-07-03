package com.santosschein.app.data.remote.api;

import com.santosschein.app.data.remote.dto.LoginRequestDto;
import com.santosschein.app.data.remote.dto.RegisterUserRequestDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthApi {

    @POST("auth/login")
    Call<Void> login(@Body LoginRequestDto request);

    @POST("auth/register")
    Call<Void> register(@Body RegisterUserRequestDto request);
}
