package com.santosschein.app.presentation.common;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.santosschein.app.R;

public abstract class BasePlaceholderFragment extends Fragment {

    protected abstract String getScreenTitle();

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        LinearLayout root = new LinearLayout(requireContext());
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(48, 48, 48, 48);
        root.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.santos_ice_white));

        TextView appName = new TextView(requireContext());
        appName.setText(R.string.app_name);
        appName.setTextColor(ContextCompat.getColor(requireContext(), R.color.santos_royal_blue));
        appName.setTextSize(22);
        appName.setGravity(Gravity.CENTER);

        TextView title = new TextView(requireContext());
        title.setText(getScreenTitle());
        title.setTextColor(ContextCompat.getColor(requireContext(), R.color.santos_graphite));
        title.setTextSize(16);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 16, 0, 0);

        root.addView(appName);
        root.addView(title);
        return root;
    }
}
