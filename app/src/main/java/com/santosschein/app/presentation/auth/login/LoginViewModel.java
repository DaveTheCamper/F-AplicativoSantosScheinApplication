package com.santosschein.app.presentation.auth.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.santosschein.app.presentation.common.UiState;

public final class LoginViewModel extends ViewModel {

    private final MutableLiveData<UiState<Void>> loginState = new MutableLiveData<>(UiState.idle());

    public LiveData<UiState<Void>> getLoginState() {
        return loginState;
    }
}
