package com.santosschein.app.core.config;

import android.content.Context;

import com.santosschein.app.core.network.RetrofitClientFactory;
import com.santosschein.app.core.session.SessionStorage;
import com.santosschein.app.core.session.SharedPreferencesSessionStorage;
import com.santosschein.app.data.mock.MockReservationRepository;
import com.santosschein.app.data.remote.api.ApiServiceFactory;
import com.santosschein.app.data.repository.RemoteReservationRepository;
import com.santosschein.app.domain.repository.ReservationRepository;
import com.santosschein.app.domain.usecase.GetInitialAppDestinationUseCase;

public final class AppContainer {

    private final AppConfig appConfig;
    private final SessionStorage sessionStorage;
    private final ReservationRepository reservationRepository;
    private final GetInitialAppDestinationUseCase initialAppDestinationUseCase;

    public AppContainer(Context context) {
        appConfig = new AppConfig();
        sessionStorage = new SharedPreferencesSessionStorage(context);
        reservationRepository = createReservationRepository();
        initialAppDestinationUseCase = new GetInitialAppDestinationUseCase(sessionStorage);
    }

    public AppConfig getAppConfig() {
        return appConfig;
    }

    public SessionStorage getSessionStorage() {
        return sessionStorage;
    }

    public ReservationRepository getReservationRepository() {
        return reservationRepository;
    }

    public GetInitialAppDestinationUseCase getInitialAppDestinationUseCase() {
        return initialAppDestinationUseCase;
    }

    private ReservationRepository createReservationRepository() {
        if (appConfig.isMockMode()) {
            return new MockReservationRepository();
        }

        ApiServiceFactory apiServiceFactory = new ApiServiceFactory(
                RetrofitClientFactory.create(appConfig, sessionStorage)
        );
        return new RemoteReservationRepository(apiServiceFactory.createReservationApi());
    }
}
