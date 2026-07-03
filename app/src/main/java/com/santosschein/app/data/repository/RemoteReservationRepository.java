package com.santosschein.app.data.repository;

import com.santosschein.app.core.error.AppError;
import com.santosschein.app.core.error.ErrorType;
import com.santosschein.app.core.util.Result;
import com.santosschein.app.data.remote.api.ReservationApi;
import com.santosschein.app.data.remote.dto.ReservationDto;
import com.santosschein.app.data.remote.dto.SoccerFieldDto;
import com.santosschein.app.data.remote.mapper.ReservationMapper;
import com.santosschein.app.data.remote.mapper.SoccerFieldMapper;
import com.santosschein.app.domain.model.Reservation;
import com.santosschein.app.domain.model.SoccerField;
import com.santosschein.app.domain.repository.ReservationRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public final class RemoteReservationRepository implements ReservationRepository {

    private final ReservationApi reservationApi;
    private final SoccerFieldMapper soccerFieldMapper;
    private final ReservationMapper reservationMapper;

    public RemoteReservationRepository(ReservationApi reservationApi) {
        this.reservationApi = reservationApi;
        this.soccerFieldMapper = new SoccerFieldMapper();
        this.reservationMapper = new ReservationMapper();
    }

    @Override
    public Result<List<SoccerField>> getAvailableFields() {
        try {
            Response<List<SoccerFieldDto>> response = reservationApi.getAvailableFields().execute();
            if (!response.isSuccessful() || response.body() == null) {
                return Result.failure(new AppError(ErrorType.NETWORK, "Erro ao carregar campos."));
            }

            List<SoccerField> fields = new ArrayList<>();
            for (SoccerFieldDto dto : response.body()) {
                fields.add(soccerFieldMapper.toDomain(dto));
            }
            return Result.success(fields);
        } catch (IOException exception) {
            return Result.failure(new AppError(ErrorType.NETWORK, "Falha de comunicacao com o backend.", null, exception));
        }
    }

    @Override
    public Result<List<Reservation>> getMyReservations() {
        try {
            Response<List<ReservationDto>> response = reservationApi.getMyReservations().execute();
            if (!response.isSuccessful() || response.body() == null) {
                return Result.failure(new AppError(ErrorType.NETWORK, "Erro ao carregar reservas."));
            }

            List<Reservation> reservations = new ArrayList<>();
            for (ReservationDto dto : response.body()) {
                reservations.add(reservationMapper.toDomain(dto));
            }
            return Result.success(reservations);
        } catch (IOException exception) {
            return Result.failure(new AppError(ErrorType.NETWORK, "Falha de comunicacao com o backend.", null, exception));
        }
    }
}
