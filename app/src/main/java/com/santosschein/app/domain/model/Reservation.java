package com.santosschein.app.domain.model;

public final class Reservation {

    private final String id;
    private final String fieldId;
    private final String fieldName;
    private final String startsAt;
    private final String endsAt;

    public Reservation(String id, String fieldId, String fieldName, String startsAt, String endsAt) {
        this.id = id;
        this.fieldId = fieldId;
        this.fieldName = fieldName;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
    }

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
