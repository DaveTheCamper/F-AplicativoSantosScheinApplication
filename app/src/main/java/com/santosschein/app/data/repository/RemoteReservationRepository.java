package com.santosschein.app.data.repository;

import com.santosschein.app.core.error.AppError;
import com.santosschein.app.core.error.ErrorType;
import com.santosschein.app.core.util.Result;
import com.santosschein.app.data.remote.api.ReservationApi;
import com.santosschein.app.domain.model.Reservation;
import com.santosschein.app.domain.model.ReservationSlot;
import com.santosschein.app.domain.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.List;

public final class RemoteReservationRepository implements ReservationRepository {

    private final ReservationApi reservationApi;

    public RemoteReservationRepository(ReservationApi reservationApi) {
        this.reservationApi = reservationApi;
    }

    @Override
    public Result<Reservation> getNextReservation() {
        return backendUnavailable();
    }

    @Override
    public Result<List<LocalDate>> getAvailableDays(int year, int month) {
        return backendUnavailable();
    }

    @Override
    public Result<List<ReservationSlot>> getAvailableSlots(LocalDate date) {
        return backendUnavailable();
    }

    @Override
    public Result<Reservation> createReservation(LocalDate date, String slotId) {
        return backendUnavailable();
    }

    @Override
    public Result<List<Reservation>> getUpcomingReservations() {
        return backendUnavailable();
    }

    @Override
    public Result<List<Reservation>> getPastReservations() {
        return backendUnavailable();
    }

    @Override
    public Result<Void> cancelReservation(String reservationId) {
        return backendUnavailable();
    }

    private <T> Result<T> backendUnavailable() {
        return Result.failure(new AppError(
                ErrorType.NETWORK,
                "Backend remoto ainda nao implementado."
        ));
    }
}
