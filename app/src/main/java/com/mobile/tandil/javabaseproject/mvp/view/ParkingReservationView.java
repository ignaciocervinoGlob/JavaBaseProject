package com.mobile.tandil.javabaseproject.mvp.view;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import com.mobile.tandil.javabaseproject.R;
import com.mobile.tandil.javabaseproject.activity.MainActivity;
import com.mobile.tandil.javabaseproject.databinding.ActivityNewParkingReservationBinding;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingReservationActivityContract;
import com.mobile.tandil.javabaseproject.mvp.view.base.ActivityView;
import com.mobile.tandil.javabaseproject.utils.GeneralUtils;
import java.util.Calendar;

public class ParkingReservationView extends ActivityView implements ParkingReservationActivityContract.ParkingReservationActivityView {
    private final ActivityNewParkingReservationBinding binding;
    private final static int oneDayInMillis = 1000;

    public ParkingReservationView(Activity activity, ActivityNewParkingReservationBinding binding) {
        super(activity);
        this.binding = binding;
    }

    @Override
    public void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - oneDayInMillis);
        datePickerDialog.show();
    }

    public void showTimePicker() {
        Calendar calendar = Calendar.getInstance();
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener) getActivity(), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    @Override
    public void showStartDateTime(String startDate) {
        binding.textNewParkingReservationActivityStartDate.setText(startDate);
    }

    @Override
    public void showEndDateTime(String endDate) {
        binding.textNewParkingReservationActivityEndDate.setText(endDate);
    }

    @Override
    public String getParkingLot() {
        return binding.inputParkingLotReservationActivity.getEditText().getText().toString();
    }

    @Override
    public String getSecurityCode() {
        return binding.inputSecurityCodeReservationActivity.getEditText().getText().toString();
    }

    @Override
    public void showErrorMessage() {
        GeneralUtils.showToast(getContext(), getContext().getString(R.string.parking_reservation_activity_error_toast_empty_input));
    }

    @Override
    public void showSuccessMessage() {
        GeneralUtils.showToast(getContext(), getContext().getString(R.string.parking_reservation_activity_success_toast));
    }

    @Override
    public void returnMainActivity() {
        Activity thisActivity = getActivity();
        if (thisActivity != null) {
            thisActivity.startActivity(new Intent(thisActivity, MainActivity.class));
        }
    }
}
