package com.santosschein.app;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.santosschein.app.core.config.AppContainer;
import com.santosschein.app.domain.model.InitialDestination;
import com.santosschein.app.presentation.navigation.AppDestination;
import com.santosschein.app.presentation.navigation.FragmentAppNavigator;

public class MainActivity extends AppCompatActivity {

    private AppContainer appContainer;
    private FragmentAppNavigator navigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appContainer = ((SantosScheinApplication) getApplication()).getAppContainer();
        navigator = new FragmentAppNavigator(getSupportFragmentManager(), R.id.fragment_container);

        if (savedInstanceState == null) {
            InitialDestination initialDestination = appContainer.getInitialAppDestinationUseCase().execute();
            navigator.navigateTo(toAppDestination(initialDestination));
        }
    }

    public AppContainer getAppContainer() {
        return appContainer;
    }

    public void navigateTo(AppDestination destination) {
        navigator.navigateTo(destination);
    }

    public void navigateBack() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            navigator.navigateTo(AppDestination.HOME);
        }
    }

    private AppDestination toAppDestination(InitialDestination initialDestination) {
        if (initialDestination == InitialDestination.HOME) {
            return AppDestination.HOME;
        }
        return AppDestination.LOGIN;
    }
}
