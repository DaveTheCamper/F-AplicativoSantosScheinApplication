package com.santosschein.app.presentation.common;

import androidx.annotation.Nullable;

import com.santosschein.app.core.error.AppError;

public final class UiState<T> {

    public enum Status {
        IDLE,
        LOADING,
        SUCCESS,
        ERROR
    }

    private final Status status;
    @Nullable
    private final T data;
    @Nullable
    private final AppError error;

    private UiState(Status status, @Nullable T data, @Nullable AppError error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static <T> UiState<T> idle() {
        return new UiState<>(Status.IDLE, null, null);
    }

    public static <T> UiState<T> loading() {
        return new UiState<>(Status.LOADING, null, null);
    }

    public static <T> UiState<T> success(T data) {
        return new UiState<>(Status.SUCCESS, data, null);
    }

    public static <T> UiState<T> error(AppError error) {
        return new UiState<>(Status.ERROR, null, error);
    }

    public Status getStatus() {
        return status;
    }

    @Nullable
    public T getData() {
        return data;
    }

    @Nullable
    public AppError getError() {
        return error;
    }
}
