package com.mobile.tandil.javabaseproject.mvp.view;

import android.content.Context;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.databinding.DialogFragmentSetParkingLotsBinding;
import com.mobile.tandil.javabaseproject.mvp.contract.SetParkingLotsContract;

public class SetParkingLotsView extends FragmentView implements SetParkingLotsContract.SetParkingLotsView {
    private final DialogFragmentSetParkingLotsBinding binding;

    public SetParkingLotsView(DialogFragment dialogFragment, DialogFragmentSetParkingLotsBinding binding) {
        super(dialogFragment);
        this.binding = binding;
    }

    @Override
    public void closeSetParkingLotsDialog() {
        DialogFragment dialogFragment = getFragment();
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }

    @Override
    public String getParkingLots() {
        return binding.inputSetParkingLotsFragment.getText().toString();
    }

    @Override
    public void showParkingLots(int lots) {
        showToast(R.string.main_activity_toast_parking_lots, lots);
    }

    @Override
    public void showErrorMessage() {
        showToast(R.string.main_activity_error_toast_parking_lots);
    }

    private void showToast(int resource, int value) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, context.getString(resource, value), Toast.LENGTH_SHORT).show();
        }
    }

    private void showToast(int resource) {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, context.getString(resource), Toast.LENGTH_SHORT).show();
        }
    }
}
