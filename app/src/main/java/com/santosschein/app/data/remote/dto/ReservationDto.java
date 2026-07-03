package com.santosschein.app.data.remote.dto;

public final class ReservationDto {

    private String id;
    private String fieldId;
    private String fieldName;
    private String startsAt;
    private String endsAt;

    public String getId() {
        return id;
    }

    public String getFieldId() {
        return fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getStartsAt() {
        return startsAt;
    }

    public String getEndsAt() {
        return endsAt;
    }
}
