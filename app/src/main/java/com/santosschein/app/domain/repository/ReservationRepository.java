package com.santosschein.app.domain.repository;

import com.santosschein.app.core.util.Result;
import com.santosschein.app.domain.model.Reservation;
import com.santosschein.app.domain.model.SoccerField;

import java.util.List;

public interface ReservationRepository {

    Result<List<SoccerField>> getAvailableFields();

    Result<List<Reservation>> getMyReservations();
}
