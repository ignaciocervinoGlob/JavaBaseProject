package com.mobile.tandil.javabaseproject.mvp.presenter;

import com.mobile.tandil.javabaseproject.listeners.ParkingLotsInputListener;
import com.mobile.tandil.javabaseproject.mvp.contract.SetParkingLotsContract;

public class SetParkingLotsPresenter implements SetParkingLotsContract.SetParkingLotsPresenter {
    private final SetParkingLotsContract.SetParkingLotsView view;
    private final ParkingLotsInputListener parkingLotsInputListener;

    public SetParkingLotsPresenter(SetParkingLotsContract.SetParkingLotsView view, ParkingLotsInputListener parkingLotsInputListener) {
        this.view = view;
        this.parkingLotsInputListener = parkingLotsInputListener;
    }

    @Override
    public void onSubmitButtonPressed() {
        String lotsString = view.getParkingLots();
        if (lotsString.isEmpty()) {
            view.showErrorMessage();
        } else {
            int lots = Integer.valueOf(lotsString);
            this.parkingLotsInputListener.shareLotsInput(lots);
            view.showParkingLots(lots);
            view.closeSetParkingLotsDialog();
        }
    }

    @Override
    public void onCancelButtonPressed() {
        view.closeSetParkingLotsDialog();
    }
}
