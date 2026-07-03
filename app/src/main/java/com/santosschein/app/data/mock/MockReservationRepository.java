package com.santosschein.app.data.mock;

import com.santosschein.app.core.util.Result;
import com.santosschein.app.domain.model.Reservation;
import com.santosschein.app.domain.model.ReservationSlot;
import com.santosschein.app.domain.model.ReservationStatus;
import com.santosschein.app.domain.repository.ReservationRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MockReservationRepository implements ReservationRepository {

    @Override
    public Result<Reservation> getNextReservation() {
        return Result.success(createMockReservation("next", LocalDate.now().plusDays(1)));
    }

    @Override
    public Result<List<LocalDate>> getAvailableDays(int year, int month) {
        List<LocalDate> days = new ArrayList<>();
        days.add(LocalDate.of(year, month, 5));
        days.add(LocalDate.of(year, month, 12));
        days.add(LocalDate.of(year, month, 19));
        return Result.success(days);
    }

    @Override
    public Result<List<ReservationSlot>> getAvailableSlots(LocalDate date) {
        List<ReservationSlot> slots = new ArrayList<>();
        slots.add(new ReservationSlot("slot-19", LocalTime.of(19, 0), LocalTime.of(20, 0), new BigDecimal("120.00")));
        slots.add(new ReservationSlot("slot-20", LocalTime.of(20, 0), LocalTime.of(21, 0), new BigDecimal("120.00")));
        return Result.success(slots);
    }

    @Override
    public Result<Reservation> createReservation(LocalDate date, String slotId) {
        return Result.success(createMockReservation(slotId, date));
    }

    @Override
    public Result<List<Reservation>> getUpcomingReservations() {
        return Result.success(Collections.singletonList(createMockReservation("upcoming", LocalDate.now().plusDays(2))));
    }

    @Override
    public Result<List<Reservation>> getPastReservations() {
        return Result.success(Collections.emptyList());
    }

    @Override
    public Result<Void> cancelReservation(String reservationId) {
        return Result.success(null);
    }

    private Reservation createMockReservation(String id, LocalDate date) {
        return new Reservation(
                id,
                "Campo Society 1",
                date,
                LocalTime.of(19, 0),
                LocalTime.of(20, 0),
                new BigDecimal("120.00"),
                ReservationStatus.SCHEDULED
        );
    }
}
