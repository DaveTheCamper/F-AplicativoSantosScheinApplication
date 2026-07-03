package com.santosschein.app.data.remote.dto;

import java.math.BigDecimal;

public final class ReservationSlotDto {

    private String id;
    private String startTime;
    private String endTime;
    private BigDecimal price;

    public String getId() {
        return id;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
