package com.mobile.tandil.javabaseproject.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import com.mobile.tandil.javabaseproject.databinding.ActivityNewParkingReservationBinding;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingReservationActivityContract;
import com.mobile.tandil.javabaseproject.mvp.model.ParkingReservationModel;
import com.mobile.tandil.javabaseproject.mvp.presenter.ParkingReservationPresenter;
import com.mobile.tandil.javabaseproject.mvp.view.ParkingReservationView;

public class ParkingReservationActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private ActivityNewParkingReservationBinding binding;
    private ParkingReservationActivityContract.ParkingReservationActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewParkingReservationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new ParkingReservationPresenter(new ParkingReservationView(this, binding), new ParkingReservationModel());

        setListeners();
    }

    public void setListeners() {
        binding.buttonNewParkingReservationActivityStartDate.setOnClickListener(view -> presenter.onStartDateButtonPressed());
        binding.buttonNewParkingReservationActivityEndDate.setOnClickListener(view -> presenter.onEndDateButtonPressed());
        binding.buttonNewParkingReservationSubmit.setOnClickListener(view -> presenter.onSubmitButtonPressed());
        binding.buttonNewParkingReservationCancel.setOnClickListener(view -> presenter.onCancelButtonPressed());
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
        presenter.onSetDate(year,monthOfYear,dayOfMonth);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minutes) {
        presenter.onSetTime(hour, minutes);
    }

}
