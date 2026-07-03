package com.santosschein.app.domain.usecase;

import com.santosschein.app.core.session.SessionStorage;
import com.santosschein.app.presentation.navigation.AppDestination;

public final class GetInitialAppDestinationUseCase {

    private final SessionStorage sessionStorage;

    public GetInitialAppDestinationUseCase(SessionStorage sessionStorage) {
        this.sessionStorage = sessionStorage;
    }

    public AppDestination execute() {
        if (sessionStorage.hasActiveSession()) {
            return AppDestination.HOME;
        }
        return AppDestination.LOGIN;
    }
}
