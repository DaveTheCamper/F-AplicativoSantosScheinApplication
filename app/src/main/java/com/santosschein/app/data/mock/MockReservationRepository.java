package com.santosschein.app.data.mock;

import com.santosschein.app.core.util.Result;
import com.santosschein.app.domain.model.Reservation;
import com.santosschein.app.domain.model.SoccerField;
import com.santosschein.app.domain.repository.ReservationRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MockReservationRepository implements ReservationRepository {

    @Override
    public Result<List<SoccerField>> getAvailableFields() {
        return Result.success(Arrays.asList(
                new SoccerField("1", "Campo Society 1", true),
                new SoccerField("2", "Campo Society 2", true)
        ));
    }

    @Override
    public Result<List<Reservation>> getMyReservations() {
        return Result.success(Collections.emptyList());
    }
}
