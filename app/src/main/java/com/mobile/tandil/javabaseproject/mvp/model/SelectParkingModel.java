package com.mobile.tandil.javabaseproject.mvp.model;

import com.mobile.tandil.javabaseproject.mvp.contract.MainActivityContract;

public class SelectParkingModel implements MainActivityContract.MainActivityModel {
    private int parkingLots;
    private static final int DEFAULT_LOTS = 0;

    public SelectParkingModel() {
        parkingLots = DEFAULT_LOTS;
    }

    @Override
    public void setParkingLots(int lots) {
        parkingLots = lots;
    }

    @Override
    public int getParkingLots() {
        return parkingLots;
    }
}
