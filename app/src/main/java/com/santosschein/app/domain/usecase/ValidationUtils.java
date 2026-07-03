package com.santosschein.app.domain.usecase;

import com.santosschein.app.core.error.AppError;
import com.santosschein.app.core.error.ErrorType;
import com.santosschein.app.core.util.Result;

final class ValidationUtils {

    private ValidationUtils() {
    }

    static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    static boolean isInvalidEmail(String email) {
        return isBlank(email) || !email.contains("@");
    }

    static <T> Result<T> validationError(String message) {
        return Result.failure(new AppError(ErrorType.VALIDATION, message));
    }
}
