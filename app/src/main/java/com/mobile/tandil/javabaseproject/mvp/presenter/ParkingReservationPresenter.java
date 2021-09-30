package com.mobile.tandil.javabaseproject.mvp.presenter;

import android.widget.DatePicker;
import com.mobile.tandil.javabaseproject.mvp.contract.ParkingReservationActivityContract;
import com.mobile.tandil.javabaseproject.utils.ConstantUtils;
import com.mobile.tandil.javabaseproject.utils.DateType;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ParkingReservationPresenter implements ParkingReservationActivityContract.ParkingReservationActivityPresenter {
    private final ParkingReservationActivityContract.ParkingReservationActivityView view;
    private final ParkingReservationActivityContract.ParkingReservationActivityModel model;

    public ParkingReservationPresenter(ParkingReservationActivityContract.ParkingReservationActivityView view, ParkingReservationActivityContract.ParkingReservationActivityModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onCancelButtonPressed() {
        view.returnMainActivity();
    }

    @Override
    public void onStartDateButtonPressed() {
        model.setStartDateType();
        view.showDatePicker();
    }

    @Override
    public void onEndDateButtonPressed() {
        model.setEndDateType();
        view.showDatePicker();
    }

    @Override
    public void onSetDate(DatePicker datePicker) {
        Calendar date = Calendar.getInstance();
        date.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
        model.setDate(date);
        view.showTimePicker();
    }

    public void onSetTime(int hour, int minute) {
        Calendar currentDate;
        if (model.getDateType() == DateType.START) {
            currentDate = model.getStartDate();
        } else {
            currentDate = model.getEndDate();
        }
        currentDate.set(Calendar.HOUR_OF_DAY, hour);
        currentDate.set(Calendar.MINUTE, minute);
        model.setTime(currentDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat(ConstantUtils.DATE_FORMAT_STRING, Locale.US);
        if (model.getDateType() == DateType.START) {
            view.showStartDateTime(dateFormat.format(model.getStartDate().getTime()));
        } else {
            view.showEndDateTime(dateFormat.format(model.getEndDate().getTime()));
        }
    }

    @Override
    public void onSubmitButtonPressed() {
        String lotString = view.getParkingLot();
        String securityCode = view.getSecurityCode();
        if (lotString.isEmpty() || securityCode.isEmpty()) {
            view.showErrorMessage();
        } else {
            model.setParkingLot(Integer.parseInt(lotString));
            model.setSecurityCode(securityCode);
            view.returnMainActivity();
            view.showSuccessMessage();
        }
    }
}
