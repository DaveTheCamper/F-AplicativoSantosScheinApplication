package com.santosschein.app.data.remote.api;

import com.santosschein.app.data.remote.dto.ReservationDto;
import com.santosschein.app.data.remote.dto.SoccerFieldDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ReservationApi {

    @GET("fields")
    Call<List<SoccerFieldDto>> getAvailableFields();

    @GET("reservations/me")
    Call<List<ReservationDto>> getMyReservations();
}
