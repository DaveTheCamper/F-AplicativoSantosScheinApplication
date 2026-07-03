package com.santosschein.app.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public final class Reservation {

    private final String id;
    private final String fieldName;
    private final LocalDate date;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final BigDecimal amount;
    private final ReservationStatus status;

    public Reservation(
            String id,
            String fieldName,
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime,
            BigDecimal amount,
            ReservationStatus status
    ) {
        this.id = id;
        this.fieldName = fieldName;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.amount = amount;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public ReservationStatus getStatus() {
        return status;
    }
}
