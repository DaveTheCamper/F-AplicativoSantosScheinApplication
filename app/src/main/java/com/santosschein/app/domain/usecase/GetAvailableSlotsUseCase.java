package com.santosschein.app.domain.usecase;

import com.santosschein.app.core.util.Result;
import com.santosschein.app.domain.model.ReservationSlot;
import com.santosschein.app.domain.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.List;

public final class GetAvailableSlotsUseCase {

    private final ReservationRepository reservationRepository;

    public GetAvailableSlotsUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Result<List<ReservationSlot>> execute(LocalDate date) {
        if (date == null) {
            return ValidationUtils.validationError("Informe a data da reserva.");
        }
        return reservationRepository.getAvailableSlots(date);
    }
}
