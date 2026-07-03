package com.santosschein.app;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.santosschein.app.core.config.AppContainer;
import com.santosschein.app.domain.model.InitialDestination;
import com.santosschein.app.presentation.navigation.AppDestination;
import com.santosschein.app.presentation.navigation.FragmentAppNavigator;

public class MainActivity extends AppCompatActivity {

    private static final int CONTENT_VIEW_ID = 1001;

    private FragmentAppNavigator navigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout container = new FrameLayout(this);
        container.setId(CONTENT_VIEW_ID);
        container.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        setContentView(container);

        AppContainer appContainer = new AppContainer(getApplicationContext());
        navigator = new FragmentAppNavigator(getSupportFragmentManager(), CONTENT_VIEW_ID);

        if (savedInstanceState == null) {
            InitialDestination initialDestination = appContainer.getInitialAppDestinationUseCase().execute();
            navigator.navigateTo(toAppDestination(initialDestination));
        }
    }

    private AppDestination toAppDestination(InitialDestination initialDestination) {
        if (initialDestination == InitialDestination.HOME) {
            return AppDestination.HOME;
        }
        return AppDestination.LOGIN;
    }
}
