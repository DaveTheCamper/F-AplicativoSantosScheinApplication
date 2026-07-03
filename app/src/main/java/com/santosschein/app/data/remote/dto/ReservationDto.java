package com.santosschein.app.data.remote.dto;

import java.math.BigDecimal;

public final class ReservationDto {

    private String id;
    private String fieldName;
    private String date;
    private String startTime;
    private String endTime;
    private BigDecimal price;
    private String status;

    public String getId() {
        return id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getDate() {
        return date;
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

    public String getStatus() {
        return status;
    }
}
