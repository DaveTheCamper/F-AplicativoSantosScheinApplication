package com.santosschein.app.presentation.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.santosschein.app.presentation.common.UiState;

public final class HomeViewModel extends ViewModel {

    private final MutableLiveData<UiState<String>> homeState = new MutableLiveData<>(UiState.idle());

    public LiveData<UiState<String>> getHomeState() {
        return homeState;
    }
}
