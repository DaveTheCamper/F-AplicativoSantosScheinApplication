package com.santosschein.app.presentation.reservation.create;

import com.santosschein.app.domain.model.ReservationSlot;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Collections;
import java.util.List;

public final class CreateReservationUiModel {

    private final YearMonth visibleMonth;
    private final List<LocalDate> availableDays;
    private final LocalDate selectedDate;
    private final List<ReservationSlot> availableSlots;
    private final ReservationSlot selectedSlot;

    public CreateReservationUiModel(
            YearMonth visibleMonth,
            List<LocalDate> availableDays,
            LocalDate selectedDate,
            List<ReservationSlot> availableSlots,
            ReservationSlot selectedSlot
    ) {
        this.visibleMonth = visibleMonth;
        this.availableDays = availableDays != null ? availableDays : Collections.emptyList();
        this.selectedDate = selectedDate;
        this.availableSlots = availableSlots != null ? availableSlots : Collections.emptyList();
        this.selectedSlot = selectedSlot;
    }

    public YearMonth getVisibleMonth() {
        return visibleMonth;
    }

    public List<LocalDate> getAvailableDays() {
        return availableDays;
    }

    public LocalDate getSelectedDate() {
        return selectedDate;
    }

    public List<ReservationSlot> getAvailableSlots() {
        return availableSlots;
    }

    public ReservationSlot getSelectedSlot() {
        return selectedSlot;
    }
}
