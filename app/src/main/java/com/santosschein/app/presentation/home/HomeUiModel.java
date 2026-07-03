package com.santosschein.app.presentation.home;

import com.santosschein.app.domain.model.Reservation;
import com.santosschein.app.domain.model.User;

public final class HomeUiModel {

    private final User user;
    private final Reservation nextReservation;

    public HomeUiModel(User user, Reservation nextReservation) {
        this.user = user;
        this.nextReservation = nextReservation;
    }

    public User getUser() {
        return user;
    }

    public Reservation getNextReservation() {
        return nextReservation;
    }
}
