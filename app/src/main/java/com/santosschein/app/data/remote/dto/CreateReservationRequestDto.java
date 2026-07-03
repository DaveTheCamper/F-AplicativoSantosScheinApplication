package com.santosschein.app.data.remote.dto;

public final class CreateReservationRequestDto {

    private final String date;
    private final String slotId;

    public CreateReservationRequestDto(String date, String slotId) {
        this.date = date;
        this.slotId = slotId;
    }

    public String getDate() {
        return date;
    }

    public String getSlotId() {
        return slotId;
    }
}
