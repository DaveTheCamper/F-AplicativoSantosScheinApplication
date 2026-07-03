package com.santosschein.app.domain.model;

import java.math.BigDecimal;
import java.time.LocalTime;

public final class ReservationSlot {

    private final String id;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final BigDecimal amount;

    public ReservationSlot(String id, LocalTime startTime, LocalTime endTime, BigDecimal amount) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.amount = amount;
    }

    public String getId() {
        return id;
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
}
