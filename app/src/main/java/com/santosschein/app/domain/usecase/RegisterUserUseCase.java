package com.santosschein.app.domain.usecase;

import com.santosschein.app.core.util.Result;
import com.santosschein.app.domain.model.RegisterUserInput;
import com.santosschein.app.domain.repository.AuthRepository;

import java.time.LocalDate;

public final class RegisterUserUseCase {

    private final AuthRepository authRepository;

    public RegisterUserUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public Result<Void> execute(RegisterUserInput input) {
        if (input == null) {
            return ValidationUtils.validationError("Informe os dados de cadastro.");
        }
        if (ValidationUtils.isBlank(input.getFirstName())) {
            return ValidationUtils.validationError("Informe o nome.");
        }
        if (ValidationUtils.isBlank(input.getLastName())) {
            return ValidationUtils.validationError("Informe o sobrenome.");
        }
        if (input.getBirthDate() == null || input.getBirthDate().isAfter(LocalDate.now())) {
            return ValidationUtils.validationError("Informe uma data de nascimento valida.");
        }
        if (ValidationUtils.isBlank(input.getDocument())) {
            return ValidationUtils.validationError("Informe o documento.");
        }
        if (ValidationUtils.isInvalidEmail(input.getEmail())) {
            return ValidationUtils.validationError("Informe um e-mail valido.");
        }
        if (ValidationUtils.isBlank(input.getPassword())) {
            return ValidationUtils.validationError("Informe a senha.");
        }
        if (input.getPassword().trim().length() < 6) {
            return ValidationUtils.validationError("A senha deve ter ao menos 6 caracteres.");
        }
        return authRepository.register(input);
    }
}
