package com.santosschein.app.data.remote.mapper;

import com.santosschein.app.data.remote.dto.SoccerFieldDto;
import com.santosschein.app.domain.model.SoccerField;

public final class SoccerFieldMapper {

    public SoccerField toDomain(SoccerFieldDto dto) {
        return new SoccerField(dto.getId(), dto.getName(), dto.isActive());
    }
}
