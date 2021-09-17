package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.Activity;
import com.mobile.tandil.javabaseproject.databinding.ActivityMainBinding;
import com.mobile.tandil.javabaseproject.mvp.contract.MainActivityContract;

public class SelectParkingView extends ActivityView implements MainActivityContract.MainActivityView {
    private final ActivityMainBinding binding;

    public SelectParkingView(Activity activity, ActivityMainBinding binding) {
        super(activity);
        this.binding = binding;
    }
}
