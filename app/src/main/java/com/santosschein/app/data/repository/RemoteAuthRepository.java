package com.santosschein.app.data.repository;

import com.santosschein.app.core.error.AppError;
import com.santosschein.app.core.error.ErrorType;
import com.santosschein.app.core.network.HttpErrorMapper;
import com.santosschein.app.core.session.SessionManager;
import com.santosschein.app.core.util.Result;
import com.santosschein.app.data.remote.api.AuthApi;
import com.santosschein.app.data.remote.dto.LoginRequestDto;
import com.santosschein.app.data.remote.mapper.RegisterUserMapper;
import com.santosschein.app.domain.model.AuthSession;
import com.santosschein.app.domain.model.RegisterUserInput;
import com.santosschein.app.domain.repository.AuthRepository;

import java.io.IOException;

import lombok.RequiredArgsConstructor;
import retrofit2.Response;

@RequiredArgsConstructor
public final class RemoteAuthRepository implements AuthRepository {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String REGISTER_CONFLICT_MESSAGE = "E-mail ou documento ja cadastrado.";

    private final AuthApi authApi;
    private final SessionManager sessionManager;
    private final HttpErrorMapper errorMapper;
    private final RegisterUserMapper registerUserMapper = new RegisterUserMapper();

    @Override
    public Result<AuthSession> login(String email, String password) {
        try {
            Response<Void> response = authApi.login(new LoginRequestDto(email, password)).execute();
            if (!response.isSuccessful()) {
                return Result.failure(errorMapper.fromHttpCode(response.code()));
            }

            String authorizationHeader = response.headers().get(AUTHORIZATION_HEADER);
            if (authorizationHeader == null || authorizationHeader.trim().isEmpty()) {
                return Result.failure(new AppError(
                        ErrorType.UNKNOWN,
                        "Ocorreu um erro inesperado. Tente novamente.",
                        null,
                        null
                ));
            }

            sessionManager.saveAuthorizationHeader(authorizationHeader);
            return Result.success(new AuthSession(sessionManager.getJwtToken(), null));
        } catch (IOException exception) {
            return Result.failure(errorMapper.fromNetworkError(exception));
        } catch (RuntimeException exception) {
            return Result.failure(errorMapper.unexpected(exception));
        }
    }

    @Override
    public Result<Void> register(RegisterUserInput input) {
        try {
            Response<Void> response = authApi.register(registerUserMapper.toDto(input)).execute();
            if (!response.isSuccessful()) {
                return Result.failure(errorMapper.fromHttpCode(response.code(), REGISTER_CONFLICT_MESSAGE));
            }
            return Result.success(null);
        } catch (IOException exception) {
            return Result.failure(errorMapper.fromNetworkError(exception));
        } catch (RuntimeException exception) {
            return Result.failure(errorMapper.unexpected(exception));
        }
    }

    @Override
    public void logout() {
        sessionManager.clearSession();
    }
}
