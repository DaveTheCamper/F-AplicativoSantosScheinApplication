package com.santosschein.app.presentation.reservation.create;

import java.time.LocalDate;

public final class CalendarDay {

    private final LocalDate date;
    private final boolean inVisibleMonth;
    private final boolean available;
    private final boolean selected;

    public CalendarDay(LocalDate date, boolean inVisibleMonth, boolean available, boolean selected) {
        this.date = date;
        this.inVisibleMonth = inVisibleMonth;
        this.available = available;
        this.selected = selected;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isInVisibleMonth() {
        return inVisibleMonth;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isSelected() {
        return selected;
    }
}
