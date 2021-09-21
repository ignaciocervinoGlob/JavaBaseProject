package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.databinding.ActivityMainBinding;
import com.mobile.tandil.javabaseproject.mvp.contract.MainActivityContract;

public class SelectParkingView extends ActivityView implements MainActivityContract.MainActivityView {
    private final ActivityMainBinding binding;

    public SelectParkingView(Activity activity, ActivityMainBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @Override
    public void showParkingLots(int lots) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, context.getString(R.string.main_activity_toast_parking_lots, lots), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public String getParkingLots() {
        return binding.inputMainActivityParkingLots.getText().toString();
    }
}
