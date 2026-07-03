package com.santosschein.app.domain.usecase;

import com.santosschein.app.core.util.Result;
import com.santosschein.app.domain.model.Reservation;
import com.santosschein.app.domain.repository.ReservationRepository;

import java.time.LocalDate;

public final class CreateReservationUseCase {

    private final ReservationRepository reservationRepository;

    public CreateReservationUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Result<Reservation> execute(LocalDate date, String slotId) {
        if (date == null) {
            return ValidationUtils.validationError("Informe a data da reserva.");
        }
        if (ValidationUtils.isBlank(slotId)) {
            return ValidationUtils.validationError("Informe o horario da reserva.");
        }
        return reservationRepository.createReservation(date, slotId.trim());
    }
}
