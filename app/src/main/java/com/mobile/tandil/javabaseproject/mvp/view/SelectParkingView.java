package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.Activity;
import com.mobile.tandil.javabaseproject.SetParkingLotsFragmentDialog;
import com.mobile.tandil.javabaseproject.databinding.ActivityMainBinding;
import com.mobile.tandil.javabaseproject.mvp.contract.MainActivityContract;

public class SelectParkingView extends ActivityView implements MainActivityContract.MainActivityView {
    private final ActivityMainBinding binding;
    private final static String DIALOG_TAG = "SetParkingLotsView";

    public SelectParkingView(Activity activity, ActivityMainBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @Override
    public void showSelectParkingLotsDialogFragment() {
        if (getActivity() != null) {
            SetParkingLotsFragmentDialog dialog = SetParkingLotsFragmentDialog.newInstance();
            dialog.show(getSupportFragmentManager(), DIALOG_TAG);
        }
    }
}
