package com.mobile.tandil.javabaseproject.mvp.view;

import androidx.fragment.app.DialogFragment;
import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.databinding.DialogFragmentSetParkingLotsBinding;
import com.mobile.tandil.javabaseproject.mvp.contract.SetParkingLotsContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.FragmentView;
import com.mobile.tandil.javabaseproject.utils.GeneralUtils;

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
        GeneralUtils.showToast(getContext(), getContext().getString(R.string.main_activity_toast_parking_lots, lots));
    }

    @Override
    public void showErrorMessage() {
        GeneralUtils.showToast(getContext(), getContext().getString(R.string.main_activity_error_toast_parking_lots));
    }

}
