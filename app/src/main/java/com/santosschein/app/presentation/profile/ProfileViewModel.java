package com.santosschein.app.presentation.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.santosschein.app.core.util.Result;
import com.santosschein.app.domain.model.User;
import com.santosschein.app.domain.usecase.GetProfileUseCase;
import com.santosschein.app.domain.usecase.LogoutUseCase;
import com.santosschein.app.presentation.common.UiState;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ProfileViewModel extends ViewModel {

    private final GetProfileUseCase getProfileUseCase;
    private final LogoutUseCase logoutUseCase;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final MutableLiveData<UiState<User>> profileState = new MutableLiveData<>(UiState.idle());

    public ProfileViewModel(GetProfileUseCase getProfileUseCase, LogoutUseCase logoutUseCase) {
        this.getProfileUseCase = getProfileUseCase;
        this.logoutUseCase = logoutUseCase;
    }

    public LiveData<UiState<User>> getProfileState() {
        return profileState;
    }

    public void load() {
        profileState.setValue(UiState.loading());
        executorService.execute(() -> {
            Result<User> result = getProfileUseCase.execute();
            if (result.isSuccess()) {
                profileState.postValue(UiState.success(result.getData()));
            } else {
                profileState.postValue(UiState.error(result.getError()));
            }
        });
    }

    public void logout() {
        logoutUseCase.execute();
    }

    @Override
    protected void onCleared() {
        executorService.shutdownNow();
    }
}
