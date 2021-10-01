package com.mobile.tandil.javabaseproject.mvp.contract;

import android.widget.DatePicker;
import com.mobile.tandil.javabaseproject.utils.DateType;
import java.util.Calendar;

public interface ParkingReservationActivityContract {
    interface ParkingReservationActivityPresenter {
        void onCancelButtonPressed();

        void onStartDateButtonPressed();

        void onEndDateButtonPressed();

        void onSetDate(DatePicker datePicker);

        void onSetTime(int hour, int minute);

        void onSubmitButtonPressed();
    }

    interface ParkingReservationActivityView {
        void showDatePicker();

        void returnMainActivity();

        void showTimePicker();

        void showStartDateTime(String startDate);

        void showEndDateTime(String endDate);

        String getParkingLot();

        String getSecurityCode();

        void showErrorMessage();

        void showSuccessMessage();
    }

    interface ParkingReservationActivityModel {
        void setDate(Calendar date);

        void setTime(Calendar selection);

        void setStartDateType();

        void setEndDateType();

        void setParkingLot(int lot);

        void setSecurityCode(String code);

        Calendar getStartDate();

        Calendar getEndDate();

        DateType getDateType();

        int getParkingLot();

        String getSecurityCode();
    }
}
