package com.santosschein.app.data.remote.dto;

import java.util.List;

public final class AvailableSlotsResponseDto {

    private List<ReservationSlotDto> slots;

    public List<ReservationSlotDto> getSlots() {
        return slots;
    }
}
