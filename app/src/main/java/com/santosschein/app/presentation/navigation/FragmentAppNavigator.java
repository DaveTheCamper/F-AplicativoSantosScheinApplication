package com.santosschein.app.presentation.navigation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.santosschein.app.presentation.auth.login.LoginFragment;
import com.santosschein.app.presentation.auth.register.RegisterFragment;
import com.santosschein.app.presentation.home.HomeFragment;
import com.santosschein.app.presentation.profile.ProfileFragment;
import com.santosschein.app.presentation.reservation.create.CreateReservationFragment;
import com.santosschein.app.presentation.reservation.detail.ReservationDetailFragment;
import com.santosschein.app.presentation.reservation.list.ReservationListFragment;

public final class FragmentAppNavigator implements AppNavigator {

    private final FragmentManager fragmentManager;
    private final int containerId;

    public FragmentAppNavigator(FragmentManager fragmentManager, int containerId) {
        this.fragmentManager = fragmentManager;
        this.containerId = containerId;
    }

    @Override
    public void navigateTo(AppDestination destination) {
        fragmentManager.beginTransaction()
                .replace(containerId, createFragment(destination))
                .commit();
    }

    private Fragment createFragment(AppDestination destination) {
        switch (destination) {
            case REGISTER:
                return new RegisterFragment();
            case HOME:
                return new HomeFragment();
            case RESERVATION_CREATE:
                return new CreateReservationFragment();
            case RESERVATION_LIST:
                return new ReservationListFragment();
            case RESERVATION_DETAIL:
                return new ReservationDetailFragment();
            case PROFILE:
                return new ProfileFragment();
            case LOGIN:
            default:
                return new LoginFragment();
        }
    }
}
