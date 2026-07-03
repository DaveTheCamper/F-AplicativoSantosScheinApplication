package com.santosschein.app.data.remote.mapper;

import com.santosschein.app.data.remote.dto.ReservationDto;
import com.santosschein.app.domain.model.Reservation;

public final class ReservationMapper {

    public Reservation toDomain(ReservationDto dto) {
        return new Reservation(
                dto.getId(),
                dto.getFieldId(),
                dto.getFieldName(),
                dto.getStartsAt(),
                dto.getEndsAt()
        );
    }
}
