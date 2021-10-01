package com.mobile.tandil.javabaseproject.mvp.model;

import com.mobile.tandil.javabaseproject.mvp.contract.ParkingReservationActivityContract;
import com.mobile.tandil.javabaseproject.utils.DateType;
import java.util.Calendar;

public class ParkingReservationModel implements ParkingReservationActivityContract.ParkingReservationActivityModel {
    private DateType dateType;
    private Calendar startDate;
    private Calendar endDate;
    private int parkingLot;
    private String securityCode;

    @Override
    public void setDate(Calendar date) {
        if (dateType == DateType.START) {
            startDate = date;
        } else {
            endDate = date;
        }
    }

    @Override
    public void setTime(Calendar selection) {
        if (dateType == DateType.START) {
            startDate = selection;
        } else {
            endDate = selection;
        }
    }

    @Override
    public void setStartDateType() {
        dateType = DateType.START;
    }

    @Override
    public void setEndDateType() {
        dateType = DateType.END;
    }

    @Override
    public void setParkingLot(int lot) {
        parkingLot = lot;
    }

    @Override
    public void setSecurityCode(String code) {
        securityCode = code;
    }

    @Override
    public DateType getDateType() {
        return dateType;
    }

    @Override
    public int getParkingLot() {
        return parkingLot;
    }

    @Override
    public String getSecurityCode() {
        return securityCode;
    }

    @Override
    public Calendar getStartDate() {
        return startDate;
    }

    @Override
    public Calendar getEndDate() {
        return endDate;
    }

}
