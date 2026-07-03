package com.santosschein.app.data.mock;

import com.santosschein.app.core.error.AppError;
import com.santosschein.app.core.error.ErrorType;
import com.santosschein.app.core.session.SessionManager;
import com.santosschein.app.core.util.Result;
import com.santosschein.app.domain.model.AuthSession;
import com.santosschein.app.domain.model.RegisterUserInput;
import com.santosschein.app.domain.model.User;
import com.santosschein.app.domain.repository.AuthRepository;

import java.util.Locale;

public final class MockAuthRepository implements AuthRepository {

    private final MockDataStore dataStore;
    private final SessionManager sessionManager;

    public MockAuthRepository(MockDataStore dataStore, SessionManager sessionManager) {
        this.dataStore = dataStore;
        this.sessionManager = sessionManager;
    }

    @Override
    public Result<AuthSession> login(String email, String password) {
        boolean validCredentials = MockDataStore.VALID_EMAIL.equalsIgnoreCase(email)
                && MockDataStore.VALID_PASSWORD.equals(password);

        if (!validCredentials) {
            return Result.failure(new AppError(ErrorType.UNAUTHORIZED, "E-mail ou senha invalidos.", "401", null));
        }

        sessionManager.saveJwtToken(MockDataStore.MOCK_TOKEN);
        return Result.success(new AuthSession(MockDataStore.MOCK_TOKEN, dataStore.getDefaultUser()));
    }

    @Override
    public Result<Void> register(RegisterUserInput input) {
        for (User user : dataStore.getUsers()) {
            if (user.getEmail().equalsIgnoreCase(input.getEmail())
                    || user.getDocument().equals(input.getDocument())) {
                return Result.failure(new AppError(
                        ErrorType.CONFLICT,
                        "E-mail ou documento ja cadastrado.",
                        "409",
                        null
                ));
            }
        }

        User user = new User(
                "user_" + (dataStore.getUsers().size() + 1),
                input.getFirstName(),
                input.getLastName(),
                input.getBirthDate(),
                input.getDocument(),
                input.getEmail().toLowerCase(Locale.ROOT)
        );
        dataStore.getUsers().add(user);
        return Result.success(null);
    }

    @Override
    public void logout() {
        sessionManager.clearSession();
    }
}
