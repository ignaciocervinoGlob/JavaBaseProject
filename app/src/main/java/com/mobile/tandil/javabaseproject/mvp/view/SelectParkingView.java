package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.Activity;
import android.content.Intent;
import com.mobile.tandil.javabaseproject.activity.ParkingReservationActivity;
import com.mobile.tandil.javabaseproject.databinding.ActivityMainBinding;
import com.mobile.tandil.javabaseproject.fragment.SetParkingLotsFragmentDialog;
import com.mobile.tandil.javabaseproject.mvp.contract.MainActivityContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.ActivityView;

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

    @Override
    public void showNewParkingReservationActivity() {
        Activity thisActivity = getActivity();
        if (thisActivity != null) {
            Intent intent = new Intent(thisActivity, ParkingReservationActivity.class);
            thisActivity.startActivity(intent);
        }
    }
}
