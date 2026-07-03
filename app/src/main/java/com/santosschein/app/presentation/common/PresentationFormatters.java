package com.santosschein.app.presentation.common;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public final class PresentationFormatters {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm", new Locale("pt", "BR"));

    private PresentationFormatters() {
    }

    public static String date(LocalDate date) {
        return date != null ? DATE_FORMAT.format(date) : "";
    }

    public static String time(LocalTime time) {
        return time != null ? TIME_FORMAT.format(time) : "";
    }

    public static String money(BigDecimal amount) {
        if (amount == null) {
            return "";
        }
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(amount);
    }
}
